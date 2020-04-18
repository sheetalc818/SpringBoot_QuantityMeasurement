package com.bridgelabz.qm.qm.enumeration;

public enum ConversionUnitType {
                FEET(12.0, TypeOfUnits.LENGTH),
                INCHES(1.0, TypeOfUnits.LENGTH),
                YARD(36.0, TypeOfUnits.LENGTH),
                CENTIMETER(0.393701, TypeOfUnits.LENGTH),
                GALLONS(3.78, TypeOfUnits.VOLUME),
                LITER(1.00, TypeOfUnits.VOLUME),
                ML(0.001, TypeOfUnits.VOLUME),
                GRAMS(1.00, TypeOfUnits.WEIGHT),
                KG(1000, TypeOfUnits.WEIGHT),
                TONNE(1000000, TypeOfUnits.WEIGHT),
                CELSIUS(2.12, TypeOfUnits.TEMPERATURE),
                FAHRENHEIT(1, TypeOfUnits.TEMPERATURE);

                public TypeOfUnits unit;
                public double baseUnit;

                ConversionUnitType(double baseUnit, TypeOfUnits unit) {
                        this.baseUnit = baseUnit;
                        this.unit = unit;
                }
}

