package com.hg.dao;

import java.util.List;

import com.hg.domain.MalfunctionRecords;

public interface IMalfunctionDao {
	List<MalfunctionRecords> findAllMalfunction();

	List<MalfunctionRecords> findAllMalfunction(String malfunctionState);

	int addMalfunction(MalfunctionRecords mr);

	int editMalfunctionState(String malfunctionId, String malfunctionState);

	int deleteMalfunction(String malfunctionId);
}
