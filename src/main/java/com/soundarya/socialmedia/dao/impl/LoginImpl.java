package com.soundarya.socialmedia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.LoggerFactory;

import com.soundarya.socialmedia.controller.IndexController;
import com.soundarya.socialmedia.dao.LoginDAO;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ErrorConstant;
import com.soundarya.socialmedia.util.ConnectionUtil;

public class LoginImpl implements LoginDAO {
	
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public String adminLogin(String email1, String password1) throws DBException {
		String sql = "select login_email,login_password from login where login_email=? and login_password=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, email1);
			pst.setString(2, password1);
			ResultSet rs = pst.executeQuery();
			Logger.debug(sql);
			String str = null;
			if (rs.next()) {
				str = "success";
				String email = rs.getString("login_email");
				// LOGGER.debug(email1);
				String password = rs.getString("login_password");
				// LOGGER.debug(password1);
				if (email.equals(email1) && password.equals(password1))
					Logger.debug(email + " Successfully Logged in");
				return str;
			} else {
				str = "failure";
				Logger.debug("Login Failed");
				return str;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

	}

	public void updatePassword(String email, String oldPassword, String newPassword) throws DBException {
		String sql = "update login set login_password =? where login_email=? and login_password=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, oldPassword);
			pst.setString(2, email);
			pst.setString(3, newPassword);
			Logger.debug(sql);
			int rows = pst.executeUpdate();
			Logger.debug(rows + " password updated");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}
}
