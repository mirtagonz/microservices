package com.py.microservices.golden;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author mgonzalez
 */
@Service
@RefreshScope
public class GoldenService {

    public PersonDataDTO getPersonData(String ci) {
        PersonDataDTO toResponse = new PersonDataDTO();
        toResponse.setName("Juan");
        toResponse.setSurname("Pueblo");
        toResponse.setCiNumber(ci);

        return toResponse;
    }
}
