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
					.prepareStatement("select * from dbo.CMMS_Account "
							+ "where AccountID = ? and PSD = ?");
			pstmt.setString(1, accountID);
			pstmt.setString(2, psd);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				user.setTel(rs.getString("TEL"));
				user.setAccountGroupID(rs.getString("AccountGroupID"));
				user.setSecGroupID(rs.getString("SecGroupID"));
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
		Connection conn = Dao.conn();
		List<User> userList = new ArrayList<User>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Account where AccountGroupID <> '1'");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				user.setTel(rs.getString("TEL"));
				user.setAccountGroupID(rs.getString("AccountGroupID"));
				user.setSecGroupID(rs.getString("SecGroupID"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	@Override
	public User searchUser(String name) {
		// TODO Auto-generated method stub
		User user = new User();
		Connection conn = Dao.conn();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Account where Name = ?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				user.setTel(rs.getString("TEL"));
				user.setAccountGroupID(rs.getString("AccountGroupID"));
				user.setSecGroupID(rs.getString("SecGroupID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into dbo.CMMS_Account (AccountID,PSD,Name,AccountGroupID) values(?,?,?,?)");
			pstmt.setString(1, user.getAccountID());
			pstmt.setString(2, user.getPsd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, "2");
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
