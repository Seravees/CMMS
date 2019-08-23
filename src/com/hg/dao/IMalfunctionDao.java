package com.hg.dao;

import java.util.List;

import com.hg.domain.MalfunctionRecords;

public interface IMalfunctionDao {
	List<MalfunctionRecords> findAllMalfunction();

	int addMalfunction(MalfunctionRecords mr);

	int editMalfunctionState(String malfunctionId, String malfunctionState);
}
