package com.bridgelabz.qm.qm.controller;

import com.bridgelabz.qm.qm.dto.QmDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.responsedto.ResponseDto;
import com.bridgelabz.qm.qm.service.IQmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantityMeasurement")
public class QmController {

    @Value("${app.allUnit}")
    private String allUnitMessage;

    @Value("${app.subUnit}")
    private String subUnitMessage;

    @Value("${app.convertUnit}")
    private String convertUnitMessage;

    @Value("${app.statusCode}")
    private int statusCode;

    @Autowired
    IQmService quantityMeasurementService;

    @GetMapping("/unit/type")
    public ResponseEntity<ResponseDto> getAllQuantityType(){
        List<TypeOfUnits> mainUnits = quantityMeasurementService.getAllUnits();
        ResponseDto responseDto = new ResponseDto(statusCode, allUnitMessage,mainUnits);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/unit/subtype")
    public ResponseEntity<ResponseDto> getUnitType(@RequestParam(value = "unit") TypeOfUnits unit) {
        List<ConversionUnitType> subUnits = quantityMeasurementService.getSubUnitType(unit);
                ResponseDto responseDto = new ResponseDto(statusCode,subUnitMessage,subUnits);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @PostMapping("/unit/conversion")
    public ResponseEntity<ResponseDto> getConvertedUnitValue(@RequestBody QmDTO quantityMeasurementDTO) {
        double convertedValue = quantityMeasurementService.getConversionUnitValue(quantityMeasurementDTO);
        ResponseDto responseDto = new ResponseDto(statusCode,convertUnitMessage,convertedValue);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
