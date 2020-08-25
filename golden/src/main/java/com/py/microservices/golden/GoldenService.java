package com.py.microservices.golden;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author mgonzalez
 */
@Service
@RefreshScope
public class GoldenService {

    public static final String OTRO_MICROSERVICE_DE_CONSULTA = "http://localhost:8090/save-person-data";
    private final RestTemplate restTemplate;
    Logger LOGGER = LoggerFactory.getLogger(GoldenService.class);

    @Value("${kangaroo.url:http://localhost:8090/save-person-data}")
    private String kangarooUrl;

    public GoldenService(RestTemplate res) {
        this.restTemplate = res;
    }

    public PersonDataDTO getPersonData(String ci) {
        PersonDataDTO toResponse = new PersonDataDTO();
        toResponse.setName("Juan");
        toResponse.setSurname("Pueblo");
        toResponse.setCiNumber(ci);

        return toResponse;
    }

    public void setPersonData(PersonDataDTO personData) {
        URI uri = URI.create(OTRO_MICROSERVICE_DE_CONSULTA);
        if (kangarooUrl != null) {
            uri = URI.create(kangarooUrl);
        } else {
            LOGGER.info("Parameter kangaroo url not exists");
        }
        LOGGER.info("Call endpoint:  {}", uri);
        this.restTemplate.postForObject(uri, personData, Void.class);
    }

}
