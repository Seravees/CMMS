package com.hg.service.impl;

import java.util.List;

import com.hg.dao.IEquipmentDao;
import com.hg.dao.impl.EquipmentDaoImpl;
import com.hg.domain.Equipment;
import com.hg.service.IEquipmentService;

public class EquipmentServiceImpl implements IEquipmentService {
	private IEquipmentDao equipmentDao = new EquipmentDaoImpl();

	@Override
	public List<Equipment> getEquipment() {
		// TODO Auto-generated method stub
		return equipmentDao.findAllEquipment();
	}

	@Override
	public int addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		return equipmentDao.addEquipment(equipment);
	}

}
