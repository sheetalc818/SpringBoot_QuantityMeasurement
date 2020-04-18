package com.bridgelabz.qm.qm.service;

import com.bridgelabz.qm.qm.dto.QuantityMeasurementDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;

import java.util.List;


public interface IQuantityMeasurementService {
    List<TypeOfUnits> getAllUnits();

    List<ConversionUnitType> getSubUnitType(TypeOfUnits unit);

    double getConversionUnitValue(QuantityMeasurementDTO quantityMeasurementDTO);
}
