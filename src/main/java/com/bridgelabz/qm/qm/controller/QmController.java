package com.bridgelabz.qm.qm.controller;

import com.bridgelabz.qm.qm.enumeration.Unit;
import com.bridgelabz.qm.qm.enumeration.UnitType;
import com.bridgelabz.qm.qm.service.IQmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quantityMeasurement")
public class QmController {

    @Autowired
    IQmService qmService;

    @GetMapping("/unit/type")
    public ResponseEntity getAllQuantityType(){
        return new ResponseEntity(Unit.values(), HttpStatus.OK);
    }

    @GetMapping("/unit/subtype")
    public List<UnitType> getUnitType(@RequestParam(value = "unit") Unit unit) {
        return qmService.getUnitType(unit);
    }
}
