package com.hg.dao;

import java.util.List;

import com.hg.domain.EquipmentType;

public interface IEquipmentTypeDao {
	List<EquipmentType> findAllEquipmentType();

	int addEquipmentType(EquipmentType equipmentType);

	int editEquipmentType(EquipmentType equipmentType);
}
