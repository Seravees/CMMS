package com.hg.service;

import java.util.List;

import com.hg.domain.EquipmentType;

public interface IEquipmentTypeService {
	List<EquipmentType> findAllEquipmentType();

	int addEquipmentType(EquipmentType equipmentType);

	int editEquipmentType(EquipmentType equipmentType);
}
