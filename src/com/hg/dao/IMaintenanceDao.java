package com.hg.dao;

import java.util.List;

import com.hg.domain.MaintenanceRecords;
import com.hg.domain.MalfunctionRecords;

public interface IMaintenanceDao {
	List<MaintenanceRecords> getMaintenanceRecordsByMalfunctionRecords(
			MalfunctionRecords malr);

	int addMaintenanceRecords(MaintenanceRecords mr);
	

}
