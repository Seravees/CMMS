package com.hg.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hg.dao.IUserDao;
import com.hg.domain.User;
import com.hg.util.Dao;

public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String accountID, String psd) {
		// TODO Auto-generated method stub
		System.out.println("flag");
		Connection conn = Dao.conn();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from dbo.CMMS_Account where AccountID='"
							+ accountID+"'and PSD='"+psd +"'");
			while (rs.next()) {
				User user = new User();
				user.setAccountID(rs.getString("AccountID"));
				user.setPsd(rs.getString("PSD"));
				user.setName(rs.getString("Name"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
