package com.soundarya.mediaApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.soundarya.mediaApp.controller.IndexController;
import com.soundarya.mediaApp.dao.FriendRequestDAO;
import com.soundarya.mediaApp.domain.FriendRequest;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ErrorConstant;
import com.soundarya.mediaApp.util.ConnectionUtil;

public class FriendRequestImpl implements FriendRequestDAO {
	 /*private static final Logger LOGGER = Logger.getInstance();
	 public static Logger getLogger() {
			return LOGGER;
		}*/
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	public void insertRequest(FriendRequest ins) throws DBException
	{
		String sql = "insert into friend_request (requestor,acceptor) values (?,?)";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst =con.prepareStatement(sql)) {
			
			LOGGER.debug(sql);
			pst.setString(1,ins.getRequestor());
			pst.setString(2,ins.getAcceptor());
			//pst.setString(3,ins.currentStatus);
			
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Row inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_ADD);

		}
	}
	
	
	public List<FriendRequest> getFriendrequest(String requestor,String currentStatus) throws DBException{
		List<FriendRequest> l = new ArrayList<FriendRequest>();
		String sql = "select * from friend_request where requestor = ? and current_status = ?";
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
			pst.setString(1, requestor);
			pst.setString(2, currentStatus);
			ResultSet rs=pst.executeQuery();
		    while(rs.next())
			{
		    	FriendRequest f=new FriendRequest();
				f.setRequestor(rs.getString("requestor"));
				f.setAcceptor(rs.getString("acceptor"));
				f.setCurrentStatus(rs.getString("current_status"));
				
				l.add(f);
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return l;
		
		
	}

	public List<FriendRequest> getRequestorList(String requestor) throws DBException{
		List<FriendRequest> l = new ArrayList<FriendRequest>();
		String sql = "select * from friend_request where requestor = ?";
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql)) 
		{
			pst.setString(1, requestor);
			ResultSet rs=pst.executeQuery();	
			while(rs.next())
			{
		    
				
				FriendRequest f=new FriendRequest();
				f.setRequestor(rs.getString("requestor"));
				f.setAcceptor(rs.getString("acceptor"));
				f.setCurrentStatus(rs.getString("current_status"));
				
				l.add(f);
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return l;
	}
	//request for me
	
	public List<FriendRequest> getAcceptorList(String acceptor) throws DBException{
		List<FriendRequest> l = new ArrayList<FriendRequest>();
		String sql = "select * from friend_request where acceptor =?";
		try (Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
			pst.setString(1, acceptor);
			  ResultSet rs=pst.executeQuery();
		    while(rs.next())
			{
		    
		    	String acp=rs.getString("acceptor");
				LOGGER.debug(acp);
				String req=rs.getString("requestor");
				LOGGER.debug(req);
				String status=rs.getString("current_status");
				LOGGER.debug(status);
				
				FriendRequest f=new FriendRequest();
				f.setRequestor(req);
				f.setAcceptor(acp);
				f.setCurrentStatus(status);
				
				l.add(f);
				
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return l;
	}

	public void updateStatus(String currentStatus,String requestor,String acceptor) throws DBException
	{
		String sql = "update friend_request set current_status=? where requestor=? and acceptor=?";
		try(Connection con=ConnectionUtil.conMethod();
			    PreparedStatement pst=con.prepareStatement(sql)) {
			pst.setString(1, currentStatus);
		    pst.setString(2, requestor);
		    pst.setString(3, acceptor);
		    LOGGER.debug(sql);
		    pst.executeUpdate();
		    LOGGER.debug("Row updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}
}
