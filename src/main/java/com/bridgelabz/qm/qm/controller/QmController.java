package com.bridgelabz.qm.qm.controller;

import com.bridgelabz.qm.qm.dto.QmDTO;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.service.IQmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantityMeasurement")
public class QmController {

    @Autowired
    IQmService qmService;

    @GetMapping("/unit/type")
    public ResponseEntity getAllQuantityType(){
        return new ResponseEntity(TypeOfUnits.values(), HttpStatus.OK);
    }

    @GetMapping("/unit/subtype")
    public List<ConversionUnitType> getUnitType(@RequestParam(value = "unit") TypeOfUnits unit) {
        return qmService.getUnitType(unit);
    }

    @PostMapping("/unit/conversion")
    public QmDTO getDTO(@RequestBody QmDTO quantityMeasurementDTO) {
        return qmService.getConvertedUnitValue(quantityMeasurementDTO);
    }
}
