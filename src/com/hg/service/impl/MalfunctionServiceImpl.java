package com.hg.service.impl;

import java.util.List;

import com.hg.dao.IMalfunctionDao;
import com.hg.dao.impl.MalfunctionDaoImpl;
import com.hg.domain.MalfunctionRecords;
import com.hg.service.IMalfunctionService;

public class MalfunctionServiceImpl implements IMalfunctionService {
	private IMalfunctionDao malfunctionDao = new MalfunctionDaoImpl();

	@Override
	public List<MalfunctionRecords> getMalfunction() {
		// TODO Auto-generated method stub
		return malfunctionDao.findAllMalfunction();
	}

	@Override
	public int addMalfunction(MalfunctionRecords mr) {
		// TODO Auto-generated method stub
		return malfunctionDao.addMalfunction(mr);
	}

	@Override
	public int editMalfunctionState(String malfunctionId,
			String malfunctionState) {
		// TODO Auto-generated method stub
		return malfunctionDao.editMalfunctionState(malfunctionId, malfunctionState);
	}

}
