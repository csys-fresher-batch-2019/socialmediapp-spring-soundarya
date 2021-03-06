package com.soundarya.socialmedia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.soundarya.socialmedia.controller.IndexController;
import com.soundarya.socialmedia.dao.LikesDAO;
import com.soundarya.socialmedia.domain.Likes;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ErrorConstant;
import com.soundarya.socialmedia.util.ConnectionUtil;

public class LikesImpl implements LikesDAO {

	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	public void save(Likes add) throws DBException {
		String sql = "insert into likes(like_post_id,like_email,like_date) values (?,?,current_timestamp)";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {

			Logger.debug(sql);

			pst.setInt(1, add.getLikePostId());
			pst.setString(2, add.getLikeEmail());

			int rows = pst.executeUpdate();
			Logger.debug(rows + "Rows inserted");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);

		}
	}

	@Override
	public int countNoOfLikes(int likePostId) throws DBException {
		System.out.println(likePostId);
		String sql = "select count(*) as no_of_likes from likes where like_post_id=?";
		int totalcount = 0;
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, likePostId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				totalcount = rs.getInt("no_of_likes");
				Logger.debug("Total :" + totalcount);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return totalcount;
	}

	@Override
	public List<Likes> findAllLikes(Likes l) throws DBException {
		List<Likes> list = new ArrayList<Likes>();
		String sql = "select like_email,like_date from likes where like_post_id=?";
		try (Connection con = ConnectionUtil.conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {

			Logger.debug(sql);
			pst.setInt(1, l.getLikePostId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String email = rs.getString("like_email");
				LocalDateTime date = rs.getTimestamp("like_date").toLocalDateTime();
				Likes l1 = new Likes();
				l1.setLikeEmail(email);
				l1.setLikeDate(date);

				list.add(l1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

}
