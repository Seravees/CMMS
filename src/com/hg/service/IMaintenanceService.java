package com.hg.service;

import java.util.List;

import com.hg.domain.MaintenanceRecords;
import com.hg.domain.MalfunctionRecords;

public interface IMaintenanceService {
	List<MaintenanceRecords> getMaintenanceRecordsByMalfunction(
			MalfunctionRecords malr);

	int addMaintenanceRecords(MaintenanceRecords mr);
	
	int updateMremarkbyMrecordsId(String mRemark,String malfunctionId);
}
