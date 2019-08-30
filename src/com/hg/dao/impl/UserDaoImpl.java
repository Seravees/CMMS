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
	/***** 登录 *****/
	@Override
	public User find(String accountID, String psd) {
		// TODO Auto-generated method stub
		User user = new User();
		Connection conn = Dao.conn();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Account "
							+ "left join CMMS_AccountGroup on CMMS_Account.AccountGroupID=CMMS_AccountGroup.AccountGroupID "
							+ "where AccountID = ? and PSD = ? ");
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
				user.setAccountGroupName(rs.getString("AccountGroupName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return user;
	}

	/***** 所有用戶查询（除管理员） *****/
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		List<User> userList = new ArrayList<User>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Account "
							+ "left join CMMS_AccountGroup on CMMS_Account.AccountGroupID=CMMS_AccountGroup.AccountGroupID "
							+ "where dbo.CMMS_Account.AccountGroupID <> '1'");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				user.setTel(rs.getString("TEL"));
				user.setAccountGroupID(rs.getString("AccountGroupID"));
				user.setSecGroupID(rs.getString("SecGroupID"));
				user.setAccountGroupName(rs.getString("AccountGroupName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	/***** 用戶查詢通過姓名 *****/
	@Override
	public List<User> searchUser(String name) {
		// TODO Auto-generated method stub

		Connection conn = Dao.conn();
		List<User> userList = new ArrayList<User>();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("select * from dbo.CMMS_Account "
							+ "left join CMMS_AccountGroup on CMMS_Account.AccountGroupID=CMMS_AccountGroup.AccountGroupID "
							+ "where Name like ? and dbo.CMMS_Account.AccountGroupID <> '1'");
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				user.setTel(rs.getString("TEL"));
				user.setAccountGroupID(rs.getString("AccountGroupID"));
				user.setSecGroupID(rs.getString("SecGroupID"));
				user.setAccountGroupName(rs.getString("AccountGroupName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	/***** 用户添加 *****/
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into dbo.CMMS_Account (AccountID,PSD,Name,TEL,AccountGroupID) values(?,?,?,?,?)");
			pstmt.setString(1, user.getAccountID());
			pstmt.setString(2, user.getPsd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getTel());
			pstmt.setString(5, user.getAccountGroupID());
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/***** 用户修改 *****/
	@Override
	public int editUser(String accountID, User user) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update dbo.CMMS_Account "
							+ "set PSD=?,Name=?,TEL=?,AccountGroupID=? where AccountID=?");
			pstmt.setString(1, user.getPsd());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getAccountGroupID());
			pstmt.setString(5, user.getAccountID());
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/***** 用户删除 *****/
	@Override
	public int deleteUser(String accountID) {
		// TODO Auto-generated method stub
		Connection conn = Dao.conn();

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("delete from dbo.CMMS_Account where AccountID=?");
			pstmt.setString(1, accountID);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
