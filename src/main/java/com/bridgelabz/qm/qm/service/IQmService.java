package com.bridgelabz.qm.qm.service;

import com.bridgelabz.qm.qm.enumeration.UnitType;
import com.bridgelabz.qm.qm.enumeration.Unit;

import java.util.List;

public interface IQmService {
    List<UnitType> getUnitType(Unit unit);
}
