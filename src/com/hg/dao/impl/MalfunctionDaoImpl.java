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

	/***** 查询所有报修记录 *****/
	@Override
	public List<MalfunctionRecords> findAllMalfunction() {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<MalfunctionRecords> malfunctionList = new ArrayList<MalfunctionRecords>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_MalfunctionRecords "
							+ "left join CMMS_MalfunctionState on "
							+ "CMMS_MalfunctionRecords.MalfunctionState=CMMS_MalfunctionState.MalfunctionState"
							+ " order by CMMS_MalfunctionRecords.MalfunctionState,MalfunctionID desc");
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
				malfunctionRecords.setMalfunctionStateName(rs
						.getString("MalfunctionStateName"));
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

	/***** 新增报修记录 *****/
	@Override
	public int addMalfunction(MalfunctionRecords mr) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into dbo.CMMS_MalfunctionRecords "
							+ "(EquipmentNO,MalfunctionMan,MalfunctionTime,MalFunctionRecords,MalfunctionState) values(?,?,?,?,?)");
			pstmt.setString(1, mr.getEquipmentNo());
			pstmt.setString(2, mr.getMalfunctionMan());
			pstmt.setString(3, mr.getMalfunctionTime());
			pstmt.setString(4, mr.getMalfunctionRecords());
			pstmt.setString(5, mr.getMalfunctionState());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/***** 报修记录状态编辑 *****/
	@Override
	public int editMalfunctionState(String malfunctionId,
			String malfunctionState) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update dbo.CMMS_MalfunctionRecords "
							+ "set MalfunctionState=? where MalfunctionID=?");
			pstmt.setString(1, malfunctionState);
			pstmt.setString(2, malfunctionId);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/***** 根据报修记录状态查询报修记录 *****/
	@Override
	public List<MalfunctionRecords> findAllMalfunction(String malfunctionState) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<MalfunctionRecords> malfunctionList = new ArrayList<MalfunctionRecords>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_MalfunctionRecords "
							+ "left join CMMS_MalfunctionState on "
							+ "CMMS_MalfunctionRecords.MalfunctionState=CMMS_MalfunctionState.MalfunctionState"
							+ " where CMMS_MalfunctionRecords.MalfunctionState =? order by MalfunctionID desc");
			pstmt.setString(1, malfunctionState);
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
				malfunctionRecords.setMalfunctionStateName(rs
						.getString("MalfunctionStateName"));
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

	/***** 报修记录删除 *****/
	@Override
	public int deleteMalfunction(String malfunctionId) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("delete from dbo.CMMS_MalfunctionRecords"
							+ " where MalfunctionID=?");
			pstmt.setString(1, malfunctionId);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
