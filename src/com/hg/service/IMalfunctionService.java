package com.hg.service;

import java.util.List;

import com.hg.domain.MalfunctionRecords;

public interface IMalfunctionService {
	List<MalfunctionRecords> getMalfunction();

	List<MalfunctionRecords> getMalfunction(String malfunctionState);

	int addMalfunction(MalfunctionRecords mr);

	int editMalfunctionState(String malfunctionId, String malfunctionState);
	
	int deleteMalfunction(String malfunctionId);
}
