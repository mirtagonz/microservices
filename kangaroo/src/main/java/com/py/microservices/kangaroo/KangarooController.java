package com.py.microservices.kangaroo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mgonzalez
 */
@RestController
@RefreshScope
public class KangarooController {

    @Autowired
    private KangarooService kangarooService;

    @PostMapping("/save-person-data")
    public ResponseEntity<Boolean> savePersonData(@RequestBody PersonDataDTO personDataDTO) {
        kangarooService.savePersonData(personDataDTO);
        return ResponseEntity.ok(true);
    }
}
