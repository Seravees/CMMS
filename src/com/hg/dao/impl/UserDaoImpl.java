package com.hg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hg.dao.IUserDao;
import com.hg.domain.User;
import com.hg.util.Dao;

public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String accountID, String psd) {
		// TODO Auto-generated method stub
		User user = new User();
		Connection conn = Dao.conn();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Account where AccountID = ? and PSD = ?");
			pstmt.setString(1, accountID);
			pstmt.setString(2, psd);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		Connection conn=Dao.conn();
		List<User> userList = new ArrayList<User>();
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from dbo.CMMS_Account");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return userList;
	}

}
