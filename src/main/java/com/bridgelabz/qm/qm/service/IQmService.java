package com.bridgelabz.qm.qm.service;

import com.bridgelabz.qm.qm.dto.QmDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.responsedto.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IQmService {
    List<TypeOfUnits> getAllUnits();

    List<ConversionUnitType> getSubUnitType(TypeOfUnits unit);

    double getConversionUnitValue(QmDTO quantityMeasurementDTO);
}
