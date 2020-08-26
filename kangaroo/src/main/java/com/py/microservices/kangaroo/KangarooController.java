package com.py.microservices.kangaroo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mgonzalez
 */
@RestController
@RefreshScope
public class KangarooController {
    public static final String MAX_TIME = "1000";

    @Autowired
    private KangarooService kangarooService;

    @PostMapping(value = "/person-data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @HystrixCommand(fallbackMethod = "fallbackSave", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = MAX_TIME)
    })
    public ResponseEntity<Boolean> setPersonData(@RequestPart("personData") @Valid PersonDataDTO personDataDTO,
                                                 @RequestPart("photo") MultipartFile photo) {
        kangarooService.savePersonData(personDataDTO);
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<Boolean> fallbackSave(PersonDataDTO personDataDTO){
        return ResponseEntity.ok(false);
    }
}
