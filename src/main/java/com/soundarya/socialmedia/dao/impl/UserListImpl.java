package com.soundarya.socialmedia.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.soundarya.socialmedia.controller.IndexController;
import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ErrorConstant;
import com.soundarya.socialmedia.util.ConnectionUtil;

public class UserListImpl implements UserListDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public int countNoOfUsers() throws DBException {
		String sql = "select count(*) as total_count from user_list where active_status='active'";
		int totalcount = 0;
		try (Connection con = ConnectionUtil.conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				totalcount = rs.getInt("total_count");
				Logger.debug("Total :" + totalcount);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return totalcount;
	}

	public List<UserList> findUser(UserList u) throws DBException {
		String sql = "select user_id,profile_pic,user_name,email,age,gender,dob,city,country,created_date,status,active_status from user_list  where email=?";
		List<UserList> list = new ArrayList<UserList>();
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, u.getEmail());
			ResultSet rs = pst.executeQuery();
			Logger.debug(sql);
			if (rs.next()) {
				UserList uc = new UserList();
				uc.setUserId(rs.getInt("user_id"));
				uc.setProfilePic(rs.getString("profile_pic"));
				uc.setUserName(rs.getString("user_name"));
				uc.setEmail(rs.getString("email"));
				uc.setAge(rs.getInt("age"));
				uc.setGender(rs.getString("gender"));
				uc.setDob(LocalDate.parse(rs.getString("dob")));
				uc.setCity(rs.getString("city"));
				uc.setCountry(rs.getString("country"));
				uc.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
				uc.setStatus(rs.getString("status"));
				uc.setActivestatus(rs.getString("active_status"));

				list.add(uc);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

		return list;
	}

	public void updateActiveStatus(UserList u) throws DBException {
		String sql = "update user_list set active_status='inactive' where user_name=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {

			Logger.debug(sql);

			pst.setString(1, u.getUserName());

			int rows = pst.executeUpdate();
			Logger.debug(rows + "Rows updated");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}

	}

	public String userLogin(UserList u) throws DBException {
		String sql = "select email,user_password from user_list where email=? and user_password=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getUserPassword());
			ResultSet rs = pst.executeQuery();
			Logger.debug(sql);
			String str = null;
			if (rs.next()) {
				str = "success";
				String email1 = rs.getString("email");
				String password1 = rs.getString("user_password");
				if (email1.equals(u.getEmail()) && password1.equals(u.getUserPassword()))
					Logger.debug(email1 + " Successfully Logged in");
				return (str);
			} else {
				str = "failure";
				Logger.debug("Login Failed");
				return (str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

	}

	public void updatePassword(UserList u) throws DBException {
		String sql = "update user_list set user_password = ? where email=? and user_password=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, u.getUserPassword());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getUserPassword());
			Logger.debug(sql);
			int rows = pst.executeUpdate(sql);
			Logger.debug(rows + " password updated");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}

	public List<UserList> findByCityAndName(String a, String city) throws DBException {
		String sql = "select profile_pic,user_name,email,age,gender from user_list where lower(user_name) like lower(?) and lower(city)=lower(?)";
		List<UserList> list = new ArrayList<UserList>();
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, "%" + a + "%");
			pst.setString(2, city);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				UserList u = new UserList();

				u.setProfilePic(rs.getString("profile_pic"));
				u.setUserName(rs.getString("user_name"));
				u.setEmail(rs.getString("email"));
				u.setAge(rs.getInt("age"));
				u.setGender(rs.getString("gender"));

				list.add(u);

			}
			Logger.debug(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

		return list;
	}

	public int save(UserList insert) throws DBException {
		String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status,user_password,profile_pic) values (us_id_s.nextval,?,?,?,?,?,?,?,current_timestamp,?,?,?)";
		int rows = 0;
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {

			Logger.debug(sql);

			pst.setString(1, insert.getUserName());
			pst.setString(2, insert.getEmail());
			pst.setInt(3, insert.getAge());
			pst.setString(4, insert.getGender());
			pst.setDate(5, Date.valueOf(insert.getDob()));
			pst.setString(6, insert.getCity());
			pst.setString(7, insert.getCountry());
			pst.setString(8, insert.getStatus());
			pst.setString(9, insert.getUserPassword());
			pst.setString(10, insert.getProfilePic());

			rows = pst.executeUpdate();
			Logger.debug(rows + "Rows inserted");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);

		}
		return rows;
	}
}