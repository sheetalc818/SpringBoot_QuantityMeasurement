package com.bridgelabz.qm.qm.dto;

import com.bridgelabz.qm.qm.enumeration.ConversionUnitType;

public class QmDTO {
    ConversionUnitType unitTypeOne;
    ConversionUnitType unitTypeTwo;
    double actualValue;
    double convertedValue;

    public ConversionUnitType getUnitTypeOne() {
        return unitTypeOne;
    }

    public ConversionUnitType getUnitTypeTwo() {
        return unitTypeTwo;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }
}
