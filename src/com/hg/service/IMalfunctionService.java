package com.hg.service;

import java.util.List;

import com.hg.domain.MalfunctionRecords;

public interface IMalfunctionService {
	List<MalfunctionRecords> getMalfunction();
}