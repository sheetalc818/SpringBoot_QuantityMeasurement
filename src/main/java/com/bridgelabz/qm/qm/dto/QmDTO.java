package com.bridgelabz.qm.qm.dto;

import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;

public class QmDTO {
    ConversionUnitType initialUnit;
    ConversionUnitType outputUnit;
    double actualValue;
    double convertedValue;

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public ConversionUnitType getInitialUnit() {
        return initialUnit;
    }

    public ConversionUnitType getOutputUnit() {
        return outputUnit;
    }

    public double getActualValue() {
        return actualValue;
    }

    public double getConvertedValue() {
        return convertedValue;
    }
}
