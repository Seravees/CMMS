package com.hg.service.impl;

import java.util.List;

import com.hg.dao.IMalfunctionDao;
import com.hg.dao.impl.MalfunctionDaoImpl;
import com.hg.domain.MalfunctionRecords;
import com.hg.service.IMalfunctionService;

public class MalfunctionServiceImpl implements IMalfunctionService {
	private IMalfunctionDao MalfunctionDao = new MalfunctionDaoImpl();

	@Override
	public List<MalfunctionRecords> getMalfunction() {
		// TODO Auto-generated method stub
		return MalfunctionDao.findAllMalfunction();
	}

}
