package com.py.microservices.golden;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mgonzalez
 */

@RestController
@RefreshScope
public class GoldenController {

    public static final String MAX_TIME = "1000";

    private Logger LOGGER = LoggerFactory.getLogger(GoldenController.class);

    @Value("${timeoutInMilliseconds:5000}")
    private Long timeout;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private GoldenService goldenService;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/person-data/{ci}")
    @HystrixCommand(fallbackMethod = "fallbackData", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = MAX_TIME)
    })
    public ResponseEntity<PersonDataDTO> getPersonData(@PathVariable("ci") String ci) throws Exception {
        if (timeout != null) {
            LOGGER.info("Time out for golden response: {}", timeout);
            Thread.sleep(timeout);
        } else {
            throw new Exception("Timeout is not present");
        }
        return ResponseEntity.ok(goldenService.getPersonData(ci));
    }

    public ResponseEntity<PersonDataDTO> fallbackData(String ci){
        return ResponseEntity.ok(new PersonDataDTO());
    }

    @PostMapping("/person-data")
    @HystrixCommand(fallbackMethod = "fallbackSave", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = MAX_TIME)
    })
    public ResponseEntity<Boolean> setPersonData(@RequestBody PersonDataDTO personDataDTO) throws Exception {
        goldenService.setPersonData(personDataDTO);
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<Boolean> fallbackSave(PersonDataDTO personDataDTO){
        return ResponseEntity.ok(false);
    }
}
