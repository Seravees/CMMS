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

}
