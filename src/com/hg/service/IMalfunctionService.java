package com.hg.service;

import java.util.List;

import com.hg.domain.MaintenanceRecords;
import com.hg.domain.MalfunctionRecords;

public interface IMalfunctionService {
	List<MalfunctionRecords> getMalfunction();

	int addMalfunction(MalfunctionRecords mr);

	int editMalfunctionState(String malfunctionId, String malfunctionState);
}
