package com.py.microservices.kangaroo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author mgonzalez
 */
@Service
@RefreshScope
public class KangarooService {

    private Logger LOGGER = LoggerFactory.getLogger(KangarooController.class);

    public void savePersonData(PersonDataDTO personDataDTO) {
        LOGGER.info("KANGAROO VA A GUARDAR LO SIGUIENTE EN SU BOLSA");
        LOGGER.info(personDataDTO.toString());
    }
}
