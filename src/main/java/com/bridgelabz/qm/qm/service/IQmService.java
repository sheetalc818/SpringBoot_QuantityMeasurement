package com.bridgelabz.qm.qm.service;

import com.bridgelabz.qm.qm.dto.QmDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;

import java.util.List;

public interface IQmService {
    List<ConversionUnitType> getUnitType(TypeOfUnits unit);

    QmDTO getConversionUnitValue(QmDTO quantityMeasurementDTO);
}
