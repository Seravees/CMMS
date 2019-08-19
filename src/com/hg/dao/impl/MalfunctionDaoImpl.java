package com.hg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hg.dao.IMalfunctionDao;
import com.hg.domain.MalfunctionRecords;
import com.hg.util.Dao;

public class MalfunctionDaoImpl implements IMalfunctionDao {

	@Override
	public List<MalfunctionRecords> findAllMalfunction() {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<MalfunctionRecords> malfunctionList = new ArrayList<MalfunctionRecords>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_MalfunctionRecords"
							+ " order by CMMS_MalfunctionRecords.MalfunctionState");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MalfunctionRecords malfunctionRecords = new MalfunctionRecords();
				malfunctionRecords.setEquipmentNo(rs.getString("EquipmentNO"));
				malfunctionRecords.setMalfunctionId(rs
						.getString("MalfunctionID"));
				malfunctionRecords.setMalfunctionMan(rs
						.getString("MalfunctionMan"));
				malfunctionRecords.setMalfunctionRecords(rs
						.getString("MalfunctionRecords"));
				malfunctionRecords.setMalfunctionState(rs
						.getString("MalfunctionState"));
				malfunctionRecords.setMalfunctionTime(rs
						.getString("MalfunctionTime"));
				malfunctionList.add(malfunctionRecords);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return malfunctionList;
	}

}
