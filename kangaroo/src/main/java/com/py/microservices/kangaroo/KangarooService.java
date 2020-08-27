package com.py.microservices.kangaroo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mgonzalez
 */
@Service
@RefreshScope
public class KangarooService {

    private Logger LOGGER = LoggerFactory.getLogger(KangarooService.class);

    public void savePersonData(PersonDataDTO personDataDTO, boolean isDev) {
        String message = isDev ? "KANGAROO VA A GUARDAR LO SIGUIENTE EN SU BOLSA" : "KANGAROO VA ENVIAR LO SIGUIENTE A BABAR";
        LOGGER.info(message);
        LOGGER.info(personDataDTO.toString());
        LOGGER.info("***************************************************");
    }

    private void dataValidation(PersonDataDTO personDataDTO) {

    }
}
