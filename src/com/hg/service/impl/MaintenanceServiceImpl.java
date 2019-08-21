package com.hg.service.impl;

import java.util.List;

import com.hg.dao.IMaintenanceDao;
import com.hg.dao.impl.MaintenanceDaoImpl;
import com.hg.domain.MaintenanceRecords;
import com.hg.domain.MalfunctionRecords;
import com.hg.service.IMaintenanceService;

public class MaintenanceServiceImpl implements IMaintenanceService {
	private IMaintenanceDao maintenanceDao = new MaintenanceDaoImpl();

	@Override
	public List<MaintenanceRecords> getMaintenanceRecordsByMalfunction(
			MalfunctionRecords malr) {
		// TODO Auto-generated method stub
		return maintenanceDao.getMaintenanceRecordsByMalfunctionRecords(malr);
	}
}
