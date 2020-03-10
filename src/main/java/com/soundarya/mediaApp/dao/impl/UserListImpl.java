package com.soundarya.mediaApp.dao.impl;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.soundarya.mediaApp.controller.IndexController;
import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ErrorConstant;
import com.soundarya.mediaApp.util.ConnectionUtil;
import com.soundarya.mediaApp.util.FileUtil;

public class UserListImpl  implements UserListDAO {
	//private static final Logger LOGGER = Logger.getInstance();
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	/*public static Logger getLogger() {
		return Logger;
	}*/

	public int noOfUsers() throws DBException
	{
		String sql = "select count(*) as total_count from user_list where active_status='active'" ;
		int totalcount = 0;
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    ResultSet rs=stmt.executeQuery(sql)) 
		{
			
		    if(rs.next())
			{
				totalcount=rs.getInt("total_count");
				Logger.debug("Total :" + totalcount);
			}
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);
	    }
		return totalcount;
	}
	

	public List<UserList> nameLike(String searchname) throws DBException {
		List<UserList> list = new ArrayList<UserList>();
		String sql = "select user_id,user_name,email,age,gender,dob,city,country,created_date,status,active_status from user_list where user_name like '%"+searchname+"%'" ;
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
				
				ResultSet rs=stmt.executeQuery(sql)) {
			
			Logger.debug(sql);
			while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				String userName=rs.getString("user_name");
				String email=rs.getString("email");
				int age=rs.getInt("age");
				String gender=rs.getString("gender");
				Date dob=rs.getDate("dob");
				String city=rs.getString("city");
				String country=rs.getString("country");
				Date createdDate=rs.getDate("created_date");
				String status=rs.getString("status");
				String activestatus=rs.getString("active_status");
				
				UserList u=new UserList();
				u.setUserId(userId);
				u.setUserName(userName);
				u.setEmail(email);
				u.setAge(age);
				u.setGender(gender);
				u.setDob(dob);
				u.setCity(city);
				u.setCountry(country);
				u.setCreatedDate(createdDate);
				u.setStatus(status);
				u.setActivestatus(activestatus);
				
				list.add(u);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}
	public String[] searchByAge(int age) throws DBException {
		String sql = "select user_name from user_list where age >="+age;
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
				
				ResultSet rs=stmt.executeQuery(sql)) {
			
			Logger.debug(sql);
		    while(rs.next())
			{
				String userName=rs.getString("user_name");
				Logger.debug(userName);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
	return null;
	}

	public List<UserList> displayUser(UserList u) throws DBException {
		String sql = "select user_id,profile_pic,user_name,email,age,gender,dob,city,country,created_date,status,active_status from user_list  where email=?";
		List<UserList> list = new ArrayList<UserList>();
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
			pst.setString(1,u.getEmail());
			ResultSet rs=pst.executeQuery();
			Logger.debug(sql);
		    if(rs.next())
			{
				UserList uc=new UserList();
				uc.setUserId(rs.getInt("user_id"));
				uc.setProfilePic(rs.getString("profile_pic"));
				uc.setUserName(rs.getString("user_name"));
				uc.setEmail(rs.getString("email"));
				uc.setAge(rs.getInt("age"));
				uc.setGender(rs.getString("gender"));
				uc.setDob(rs.getDate("dob"));
				uc.setCity(rs.getString("city"));
				uc.setCountry(rs.getString("country"));
				uc.setCreatedDate(rs.getDate("created_date"));
				uc.setStatus(rs.getString("status"));
				uc.setActivestatus(rs.getString("active_status"));
				
				list.add(uc);
				
				/*String userId1=String.valueOf(userId);
				//String age1=String.valueOf(age);
				//String dob1=String.valueOf(dob);
				//String createdDate1=String.valueOf(createdDate);
				
				//String newResult= "Id:"+userId1+"\n"+"Name:"+userName+"\n"+"Email:"+email+"\n"+"Age:"+age1+"\n"+"Gender:"+gender+"\n"+"Date of Birth:"+dob1+"\n"+"City:"+city+"\n"+"Country:"+country+"\n"+"Created Date:"+createdDate1+"\n"+"Status:"+status;
				//LOGGER.debug(newResult);
				//file write
				//FileUtil.WriteFile("display.txt",newResult,StandardOpenOption.APPEND);
				//LOGGER.debug("Exported Successfully");
				 //file read
				String fname="display.txt";
				Path path=Paths.get(fname);
				
				byte[] bytes=Files.readAllBytes(path);
				String content=new String(bytes);
				LOGGER.debug(content);
				LOGGER.debug("Imported Successfully");*/
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		
		return list;
	}
	
	public void updateActiveStatus(UserList u) throws DBException {
		String sql = "update user_list set active_status='inactive' where user_name=?";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst=con.prepareStatement(sql)) {
			
		    //Statement stmt=con.createStatement();
			//String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status) values (users_id_seq.nextval,'harrys','harrys@gmail.com',20,'male',to_date('13-01-1999','dd-MM-yyyy'),'virudhunagar','India',current_timestamp,'i_am_harry')";
			
			Logger.debug(sql);
			
			pst.setString(1, u.getUserName());
			
			int rows=pst.executeUpdate();
			Logger.debug(rows+"Rows updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
		
	}
	public String userLogin(UserList u) throws DBException {
		String sql = "select email,user_password from user_list where email=? and user_password=?";
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getUserPassword());
			ResultSet rs=pst.executeQuery();
			Logger.debug(sql);
			String str=null;
			if(rs.next())
			{
				str="success";
				String email1=rs.getString("email");
				String password1=rs.getString("user_password");
				if(email1.equals(u.getEmail()) && password1.equals(u.getUserPassword()))
					Logger.debug(email1+" Successfully Logged in");
				return (str);
			}
			else
			{
				str="failure";
				Logger.debug("Login Failed");	
				return (str);
			}
			

		}
		catch (Exception e) {
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

			
		}
		

	}
	
	public void updatePassword(UserList u) throws DBException
	{
		String sql = "update user_list set user_password = ? where email=? and user_password=?";
		try (Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
			pst.setString(1, u.getUserPassword());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getUserPassword());
			Logger.debug(sql);
		    int rows=pst.executeUpdate(sql);
		    Logger.debug(rows +" password updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_UPDATE);

		}
	}
	public List<UserList> searchByCityAndName(String a,String city) throws DBException {
		String sql = "select profile_pic,user_name,email,age,gender from user_list where lower(user_name) like lower(?) and lower(city)=lower(?)";
		List<UserList> list = new ArrayList<UserList>();
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
			pst.setString(1, "%"+a+"%");
			pst.setString(2,city);
			ResultSet rs=pst.executeQuery();
		    while(rs.next())
			{
	
				UserList u=new UserList();
				
				u.setProfilePic(rs.getString("profile_pic"));
				u.setUserName(rs.getString("user_name"));
				u.setEmail(rs.getString("email"));
				u.setAge(rs.getInt("age"));
				u.setGender(rs.getString("gender"));
				
			list.add(u);
				
			}
		    Logger.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_SELECT);

		}
		
		return list;
	}

	public int insertUsers(UserList insert) throws DBException {
		String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status,user_password,profile_pic) values (us_id_s.nextval,?,?,?,?,?,?,?,current_timestamp,?,?,?)";
		int rows=0;
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst=con.prepareStatement(sql)) {
			
			
			Logger.debug(sql);
			
			pst.setString(1, insert.getUserName());
			pst.setString(2, insert.getEmail());
			pst.setInt(3, insert.getAge());
			pst.setString(4, insert.getGender());
			pst.setDate(5, insert.getDob());
			pst.setString(6, insert.getCity());
			pst.setString(7, insert.getCountry());
			pst.setString(8, insert.getStatus());
			pst.setString(9, insert.getUserPassword());
			pst.setString(10, insert.getProfilePic());
		   
		    rows=pst.executeUpdate();
		    Logger.debug(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    	throw new DBException(ErrorConstant.INVALID_ADD);

		}	
		return rows;
	}
}