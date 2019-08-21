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

	@Override
	public List<MaintenanceRecords> getMaintenanceRecordsByMalfunctionRecords(
			MalfunctionRecords malr) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<MaintenanceRecords> list = new ArrayList<MaintenanceRecords>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_MaintenanceRecords "
							+ "where MalfunctionID = ?");
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

}
