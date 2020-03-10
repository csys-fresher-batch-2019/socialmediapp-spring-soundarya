package com.soundarya.mediaApp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.soundarya.mediaApp.controller.IndexController;
import com.soundarya.mediaApp.dao.CommentsDAO;
import com.soundarya.mediaApp.domain.Comments;
import com.soundarya.mediaApp.domain.Likes;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ErrorConstant;
import com.soundarya.mediaApp.util.ConnectionUtil;

public class CommentsImpl implements CommentsDAO{
	/* private static final Logger LOGGER = Logger.getInstance();
	 public static Logger getLogger() {
			return LOGGER;
		}*/
		private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	public void insertComments(Comments ins) throws DBException
	{
		String sql = "insert into comments (cmt_post_id,cmt_email,cmts,cmt_date) values (?,?,?,current_timestamp)";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst =con.prepareStatement(sql)) {
			
			
			LOGGER.debug(sql);
			
			
			pst.setInt(1,ins.getCmtPostId());
			pst.setString(2,ins.getCmtEmail());
			pst.setString(3,ins.getCmts());
			
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_ADD);

		}
	}
	public List<Comments> displayPostsWithComments() throws DBException
	{
		List<Comments> list = new ArrayList<Comments>();
		String sql = "select u.user_name,p.caption,c.cmts,c.cmt_email,c.cmt_date from user_list u,posts p,comments c where u.email=p.email and p.post_id=c.cmt_post_id";
		try (Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			
			
		    
		    LOGGER.debug(sql);
		    
		    while(rs.next())
			{
				String username=rs.getString("user_name");
				
				String caption=rs.getString("caption");
				
				String cmts=rs.getString("cmts");
				
				String cmtEmail=rs.getString("cmt_email");
				
				String cmtDate1=rs.getString("cmt_date");
				
				Comments c = new Comments();
				c.setUserName(username);
				c.setCaption(caption);
				c.setCmts(cmts);
				c.setCmtEmail(cmtEmail);
				c.setCmtDate1(cmtDate1);;
				list.add(c);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}		
		
		return list;
		
	}


	

	public int noOfComments(int cmtPostId) throws DBException {
		System.out.println(cmtPostId);
		String sql = "select count(*) as no_of_comments from comments where cmt_post_id=?" ;
		int totalcount = 0;
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
		pst.setInt(1,cmtPostId);
		 ResultSet rs=pst.executeQuery();		
			
			
		    if(rs.next())
			{
				totalcount=rs.getInt("no_of_comments");
				LOGGER.debug("Total Comments:" + totalcount);
			}
	    
		}catch(Exception e)
	    {
	    	e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

	    }
		return totalcount;
	}

	public List<Comments> displayComments(Comments l) throws DBException {
		List<Comments> list = new ArrayList<Comments>();
		String sql = "select cmt_email,cmt_date,cmts from comments where cmt_post_id=?" ;
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst =con.prepareStatement(sql)) {
			
			LOGGER.debug(sql);
			pst.setInt(1, l.getCmtPostId());
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
		    	
				String email=rs.getString("cmt_email");
				String cmt=rs.getString("cmts");
				String date=rs.getString("cmt_date");
				Comments l1=new Comments();
				l1.setCmtEmail(email);
				l1.setCmts(cmt);
				l1.setCmtDate(date);
				
				list.add(l1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
			return list;
	}



	

}
