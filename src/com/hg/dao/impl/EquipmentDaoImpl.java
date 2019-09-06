package com.hg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hg.dao.IEquipmentDao;
import com.hg.domain.Equipment;
import com.hg.util.Dao;

public class EquipmentDaoImpl implements IEquipmentDao {

	/***** 查询所有设备 *****/
	@Override
	public List<Equipment> findAllEquipment() {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<Equipment> list = new ArrayList<Equipment>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Equipment");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Equipment equipment = new Equipment();
				equipment.setEquipmentNo(rs.getString("EquipmentNO"));
				equipment.setEquipmentType(rs.getString("EquipmentTYPE"));
				equipment.setEquipmentNameInside(rs
						.getString("EquipmentNAME_INSIDE"));
				equipment.setEquipmentNameOutside(rs
						.getString("EquipmentNAME_OUTSIDE"));
				equipment.setAccountStarttime(rs.getString("AccountStarttime"));
				equipment.setEquipmentState(rs.getString("EquipmentState"));
				equipment.setEquipmentAddress(rs.getString("EquipmentAddress"));
				equipment.setEquipmentGps(rs.getString("EquipmentGPS"));
				equipment.setEquipmentRemark(rs.getString("Remark"));
				list.add(equipment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/***** 新增设备 *****/
	@Override
	public int addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into dbo.CMMS_Equipment "
							+ "(EquipmentNO,EquipmentTYPE,EquipmentNAME_INSIDE,EquipmentNAME_OUTSIDE,AccountStarttime,EquipmentState,EquipmentAddress,EquipmentGPS,Remark) "
							+ "values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, equipment.getEquipmentNo());
			pstmt.setString(2, equipment.getEquipmentType());
			pstmt.setString(3, equipment.getEquipmentNameInside());
			pstmt.setString(4, equipment.getEquipmentNameOutside());
			pstmt.setString(5, equipment.getAccountStarttime());
			pstmt.setString(6, equipment.getEquipmentState());
			pstmt.setString(7, equipment.getEquipmentAddress());
			pstmt.setString(8, equipment.getEquipmentGps());
			pstmt.setString(9, equipment.getEquipmentRemark());

			rs = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/***** 修改设备信息 *****/
	@Override
	public int editEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update dbo.CMMS_Equipment "
							+ "set EquipmentTYPE=?,EquipmentNAME_INSIDE=?,EquipmentNAME_OUTSIDE=?,AccountStarttime=?,"
							+ "EquipmentState=?,EquipmentAddress=?,EquipmentGPS=?,Remark=? "
							+ "where EquipmentNO=?");
			pstmt.setString(1, equipment.getEquipmentType());
			pstmt.setString(2, equipment.getEquipmentNameInside());
			pstmt.setString(3, equipment.getEquipmentNameOutside());
			pstmt.setString(4, equipment.getAccountStarttime());
			pstmt.setString(5, equipment.getEquipmentState());
			pstmt.setString(6, equipment.getEquipmentAddress());
			pstmt.setString(7, equipment.getEquipmentGps());
			pstmt.setString(8, equipment.getEquipmentRemark());
			pstmt.setString(9, equipment.getEquipmentNo());

			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
