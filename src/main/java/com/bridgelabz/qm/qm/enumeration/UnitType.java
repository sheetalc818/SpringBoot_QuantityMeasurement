package com.bridgelabz.qm.qm.enumeration;

public enum UnitType {
                FEET(12.0,Unit.LENGTH),
                INCHES(1.0,Unit.LENGTH),
                YARD(36.0,Unit.LENGTH),
                CENTIMETER(0.393701,Unit.LENGTH),
                GALLONS(3.78,Unit.VOLUME),
                LITER(1.00, Unit.VOLUME),
                ML(0.001,Unit.VOLUME),
                GRAMS(1.00, Unit.WEIGHT),
                KG(1000,Unit.WEIGHT),
                TONNE(1000000, Unit.WEIGHT),
                CELSIUS(0.0,Unit.TEMPERATURE),
                FAHRENHEIT(0.0,Unit.TEMPERATURE);

                public Unit unit;
                public double baseUnit;

                UnitType(double baseUnit, Unit unit) {
                        this.baseUnit = baseUnit;
                        this.unit = unit;
                }
}

