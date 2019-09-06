package com.hg.service;

import java.util.List;

import com.hg.domain.Equipment;

public interface IEquipmentService {
	List<Equipment> getEquipment();

	int addEquipment(Equipment equipment);

	int editEquipment(Equipment equipment);
}
