package com.hg.service.impl;

import java.util.List;

import com.hg.dao.IEquipmentTypeDao;
import com.hg.dao.impl.EquipmentTypeDaoImpl;
import com.hg.domain.EquipmentType;
import com.hg.service.IEquipmentTypeService;

public class EquipmentTypeServiceImpl implements IEquipmentTypeService {
	private IEquipmentTypeDao equipmentTypeDao = new EquipmentTypeDaoImpl();

	@Override
	public List<EquipmentType> findAllEquipmentType() {
		// TODO Auto-generated method stub
		return equipmentTypeDao.findAllEquipmentType();
	}

	@Override
	public int addEquipmentType(EquipmentType equipmentType) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.addEquipmentType(equipmentType);
	}

	@Override
	public int editEquipmentType(EquipmentType equipmentType) {
		// TODO Auto-generated method stub
		return equipmentTypeDao.editEquipmentType(equipmentType);
	}

}
