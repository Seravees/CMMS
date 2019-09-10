package com.hg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hg.dao.IEquipmentTypeDao;
import com.hg.domain.EquipmentType;
import com.hg.util.Dao;

public class EquipmentTypeDaoImpl implements IEquipmentTypeDao {

	@Override
	public List<EquipmentType> findAllEquipmentType() {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_EquipmentType");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				EquipmentType equipmentType = new EquipmentType();
				equipmentType.setTypeId(rs.getString("TYPEID"));
				equipmentType.setTypeName(rs.getString("NAME"));
				equipmentType.setRemark(rs.getString("Remark"));
				list.add(equipmentType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addEquipmentType(EquipmentType equipmentType) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into dbo.CMMS_EquipmentType "
							+ "(TYPEID,NAME,Remark) values(?,?,?)");
			pstmt.setString(1, equipmentType.getTypeId());
			pstmt.setString(2, equipmentType.getTypeName());
			pstmt.setString(3, equipmentType.getRemark());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public int editEquipmentType(EquipmentType equipmentType) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		int rs = 0;

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update dbo.CMMS_EquipmentType "
							+ "set NAME=?,Remark=? where TYPEID=?");
			pstmt.setString(1, equipmentType.getTypeName());
			pstmt.setString(2, equipmentType.getRemark());
			pstmt.setString(3, equipmentType.getTypeId());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
