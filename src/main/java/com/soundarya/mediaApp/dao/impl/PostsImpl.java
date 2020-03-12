package com.soundarya.mediaApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.soundarya.mediaApp.controller.IndexController;
import com.soundarya.mediaApp.dao.PostsDAO;
import com.soundarya.mediaApp.domain.Posts;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ErrorConstant;
import com.soundarya.mediaApp.util.ConnectionUtil;

public class PostsImpl implements PostsDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public int countNoOfPosts(String email) throws DBException {
		String sql = "select count(*) as no_of_posts from posts where email=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			Logger.debug(sql);

			while (rs.next()) {
				int count = rs.getInt("no_of_posts");
				Logger.debug("Count" + count);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return 0;

	}

	public void updatePost(Posts up) throws DBException {
		String sql = "update posts set date_posted = current_timestamp,caption='" + up.getCaption() + "' where email='"
				+ up.getEmail() + "' and post_id=" + up.getPostId();
		try (Connection con = ConnectionUtil.conMethod(); Statement stmt = con.createStatement()) {

			Logger.debug(sql);
			int rows = stmt.executeUpdate(sql);
			Logger.debug(rows + "updated");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}

	public void save(Posts add) throws DBException {

		String sql = "insert into posts (post_id,email,post_type,caption,viewability,date_posted) values (pos_id_se.nextval,?,?,?,?,current_timestamp)";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {

			Logger.debug(sql);

			pst.setString(1, add.getEmail());
			pst.setString(2, add.getPostType());
			pst.setString(3, add.getCaption());
			pst.setString(4, add.getViewability());
			int rows = pst.executeUpdate();
			Logger.debug(rows + "Rows updated");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);

		}

	}

	public List<Posts> findAllPosts() throws DBException {
		List<Posts> list = new ArrayList<Posts>();
		String sql = "select u.user_name,p.email,p.post_type,p.caption,p.date_posted from user_list u inner join posts p on u.email=p.email ";
		try (Connection con = ConnectionUtil.conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			Logger.debug(sql);

			while (rs.next()) {
				

				Posts p = new Posts();
				p.setUserName(rs.getString("user_name"));
				p.setEmail(rs.getString("email"));
				p.setPostType(rs.getString("post_type"));
				p.setCaption(rs.getString("caption"));
				p.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());

				list.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Posts> findAllFriendsPosts(String req) throws DBException {
		List<Posts> list = new ArrayList<Posts>();
		String sql = "select * from posts where  email in (\r\n"
				+ "select acceptor from friend_request where requestor = ? and current_status='accepted' ) order by date_posted desc";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, req);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Posts p = new Posts();
				p.setPostId(rs.getInt("post_id"));
				p.setEmail(rs.getString("email"));
				p.setPostType(rs.getString("post_type"));
				p.setCaption(rs.getString("caption"));
				p.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());

				list.add(p);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Posts> findAllFriendsPosts1(String req) throws DBException {
		List<Posts> list = new ArrayList<Posts>();
		String sql = "select * from posts where  email in (\r\n"
				+ "select requestor from friend_request where acceptor = ? and current_status='accepted' ) order by date_posted desc";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, req);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Posts p = new Posts();
				p.setPostId(rs.getInt("post_id"));
				p.setEmail(rs.getString("email"));
				p.setPostType(rs.getString("post_type"));
				p.setCaption(rs.getString("caption"));
				p.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());


				list.add(p);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Posts> findAllPublicPosts() throws DBException {
		List<Posts> list = new ArrayList<Posts>();
		String sql = "select * from posts where viewability='public'";
		try (Connection con = ConnectionUtil.conMethod();
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				Posts p = new Posts();
				p.setPostId(rs.getInt("post_id"));
				p.setEmail(rs.getString("email"));
				p.setPostType(rs.getString("post_type"));
				p.setCaption(rs.getString("caption"));
				p.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());

				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	public List<Posts> findMyPosts(String emailId) throws DBException {
		List<Posts> list = new ArrayList<Posts>();
		String sql = "select * from posts where email=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, emailId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Posts p = new Posts();
				p.setPostId(rs.getInt("post_id"));
				p.setEmail(rs.getString("email"));
				p.setPostType(rs.getString("post_type"));
				p.setCaption(rs.getString("caption"));
				p.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());

				list.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

	@Override
	public void deletePost(Posts d) throws DBException {
		String sql = "delete from posts where post_id=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {

			Logger.debug(sql);
			pst.setInt(1, d.getPostId());
			int rows = pst.executeUpdate();
			Logger.debug(rows + "updated");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_DELETE);

		}

	}

}
