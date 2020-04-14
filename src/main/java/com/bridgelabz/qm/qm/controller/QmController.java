package com.bridgelabz.qm.qm.controller;

import com.bridgelabz.qm.qm.config.ApplicationConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quantityMeasurement")
public class QmController {

    @GetMapping("/unit/type")
    public ResponseEntity getAllQuantityType(){
        return new ResponseEntity(ApplicationConfig.TypeOfUnits.values(), HttpStatus.OK);
    }
}
