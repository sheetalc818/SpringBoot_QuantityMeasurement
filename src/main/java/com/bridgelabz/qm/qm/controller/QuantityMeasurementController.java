package com.bridgelabz.qm.qm.controller;

import com.bridgelabz.qm.qm.dto.QuantityMeasurementDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.responsedto.ResponseDTO;
import com.bridgelabz.qm.qm.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantityMeasurement")
public class QuantityMeasurementController {

    @Value("${app.allUnit}")
    private String allUnitMessage;

    @Value("${app.subUnit}")
    private String subUnitMessage;

    @Value("${app.convertUnit}")
    private String convertUnitMessage;

    @Value("${app.statusCode}")
    private int statusCode;

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("/unit/type")
    public ResponseEntity<ResponseDTO> getAllQuantityType(){
        List<TypeOfUnits> mainUnits = quantityMeasurementService.getAllUnits();
        ResponseDTO responseDto = new ResponseDTO(statusCode, allUnitMessage,mainUnits);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/unit/subtype")
    public ResponseEntity<ResponseDTO> getUnitType(@RequestParam(value = "unit") TypeOfUnits unit) {
        List<ConversionUnitType> subUnits = quantityMeasurementService.getSubUnitType(unit);
        ResponseDTO responseDto = new ResponseDTO(statusCode,subUnitMessage,subUnits);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @PostMapping("/unit/conversion")
    public ResponseEntity<ResponseDTO> getConvertedUnitValue(@RequestBody QuantityMeasurementDTO quantityMeasurementDTO) {
        double convertedValue = quantityMeasurementService.getConversionUnitValue(quantityMeasurementDTO);
        ResponseDTO responseDto = new ResponseDTO(statusCode,convertUnitMessage,convertedValue);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
