package com.bridgelabz.qm.qm.service.implementation;

import com.bridgelabz.qm.qm.dto.QmDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.service.IQmService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QmService implements IQmService {

    @Override
    public List<ConversionUnitType> getUnitType(TypeOfUnits unit) {
        return Arrays.stream(ConversionUnitType.values()).filter(unitType -> unitType.unit.equals(unit)).collect(Collectors.toList());
    }

    @Override
    public QmDTO getDTO(QmDTO quantityMeasurementDTO) {
        double convertedValue = (quantityMeasurementDTO.getUnitTypeOne().baseUnit * quantityMeasurementDTO.getActualValue())/quantityMeasurementDTO.getUnitTypeTwo().baseUnit;
        quantityMeasurementDTO.setConvertedValue(convertedValue);
        return quantityMeasurementDTO;
    }
}
