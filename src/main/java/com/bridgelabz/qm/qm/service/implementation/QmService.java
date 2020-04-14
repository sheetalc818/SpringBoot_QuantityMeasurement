package com.bridgelabz.qm.qm.service.implementation;

import com.bridgelabz.qm.qm.enumeration.UnitType;
import com.bridgelabz.qm.qm.enumeration.Unit;
import com.bridgelabz.qm.qm.service.IQmService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QmService implements IQmService {

    @Override
    public List<UnitType> getUnitType(Unit unit) {
        return Arrays.stream(UnitType.values()).filter(unitType -> unitType.unit.equals(unit)).collect(Collectors.toList());
    }
}
