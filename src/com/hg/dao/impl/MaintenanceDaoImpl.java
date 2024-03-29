package com.hg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hg.dao.IMaintenanceDao;
import com.hg.domain.MaintenanceRecords;
import com.hg.domain.MalfunctionRecords;
import com.hg.util.Dao;

public class MaintenanceDaoImpl implements IMaintenanceDao {

	/***** 根据报修记录ID查询所有维修记录，递减排序 *****/
	@Override
	public List<MaintenanceRecords> getMaintenanceRecordsByMalfunctionRecords(
			MalfunctionRecords malr) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<MaintenanceRecords> list = new ArrayList<MaintenanceRecords>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_MaintenanceRecords "
							+ "where MalfunctionID = ? order by MRecords_ID desc");
			pstmt.setString(1, malr.getMalfunctionId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MaintenanceRecords mr = new MaintenanceRecords();
				mr.setmRecordsId(rs.getString("MRecords_ID"));
				mr.setEquipmentNo(rs.getString("EquipmentNO"));
				mr.setMalfunctionId(rs.getString("MalfunctionID"));
				mr.setmStarttime(rs.getString("MStarttime"));
				mr.setmEndtime(rs.getString("MEndtime"));
				mr.setmManName(rs.getString("MManName"));
				mr.setmResultRecords(rs.getString("MResultRecords"));
				mr.setmState(rs.getString("MState"));
				mr.setmRemark(rs.getString("MRemark"));
				list.add(mr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/***** 维修记录添加 *****/
	@Override
	public int addMaintenanceRecords(MaintenanceRecords mr) {
		// TODO Auto-generated method stub
		int rs = 0;
		Connection conn = Dao.conn();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into dbo.CMMS_MaintenanceRecords "
							+ "(EquipmentNO,MStarttime,MEndtime,MalfunctionID,MManName,MResultRecords,MState,MRemark) "
							+ "values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, mr.getEquipmentNo());
			pstmt.setString(2, mr.getmStarttime());
			pstmt.setString(3, mr.getmEndtime());
			pstmt.setString(4, mr.getMalfunctionId());
			pstmt.setString(5, mr.getmManName());
			pstmt.setString(6, mr.getmResultRecords());
			pstmt.setString(7, mr.getmState());
			pstmt.setString(8, mr.getmRemark());

			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/***** 最新的维修记录备注修改 *****/
	@Override
	public int updateMremarkbyMrecordsId(String mRemark, String malfunctionId) {
		// TODO Auto-generated method stub
		int rs = 0;
		Connection conn = Dao.conn();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update dbo.CMMS_MaintenanceRecords "
							+ "set MRemark = ? where MRecords_ID = "
							+ "(select top 1 MRecords_ID from dbo.CMMS_MaintenanceRecords where MalfunctionID = ? order by MRecords_ID desc )");
			pstmt.setString(1, mRemark);
			pstmt.setString(2, malfunctionId);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
