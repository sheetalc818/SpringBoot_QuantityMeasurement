package com.bridgelabz.qm.qm.service.implementation;

import com.bridgelabz.qm.qm.dto.QuantityMeasurementDTO;
import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;
import com.bridgelabz.qm.qm.enumeration.TypeOfUnits;
import com.bridgelabz.qm.qm.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public List<TypeOfUnits> getAllUnits() {
        return Arrays.stream(TypeOfUnits.values()).collect(Collectors.toList());
    }

    @Override
    public List<ConversionUnitType> getSubUnitType(TypeOfUnits unit) {
        return Arrays.stream(ConversionUnitType.values()).filter(unitType -> unitType.unit.equals(unit)).collect(Collectors.toList());
    }

    @Override
    public double getConversionUnitValue(QuantityMeasurementDTO quantityMeasurementDTO) {
        if (quantityMeasurementDTO.getInitialUnit().unit.equals(TypeOfUnits.TEMPERATURE)){
            return conversionForTemperatureUnit(quantityMeasurementDTO);
        }
        double convertedValue = (quantityMeasurementDTO.getInitialUnit().baseUnit * quantityMeasurementDTO.getActualValue())/quantityMeasurementDTO.getOutputUnit().baseUnit;
        quantityMeasurementDTO.setConvertedValue(convertedValue);
        return convertedValue;
    }

    private double conversionForTemperatureUnit(QuantityMeasurementDTO quantityMeasurementDTO) {
        if (quantityMeasurementDTO.getInitialUnit() == ConversionUnitType.CELSIUS && quantityMeasurementDTO.getOutputUnit() == ConversionUnitType.FAHRENHEIT){
            return (quantityMeasurementDTO.getActualValue() * quantityMeasurementDTO.getInitialUnit().baseUnit) + 32;
        }else if (quantityMeasurementDTO.getInitialUnit() == ConversionUnitType.FAHRENHEIT && quantityMeasurementDTO.getOutputUnit() == ConversionUnitType.CELSIUS){
            return (quantityMeasurementDTO.getActualValue() -32 * quantityMeasurementDTO.getInitialUnit().baseUnit);
        }
        return (quantityMeasurementDTO.getInitialUnit().baseUnit * quantityMeasurementDTO.getActualValue())/quantityMeasurementDTO.getOutputUnit().baseUnit;
    }
}
