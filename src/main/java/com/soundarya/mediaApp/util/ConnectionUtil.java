package com.soundarya.mediaApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ErrorConstant;

public class ConnectionUtil {
	public static Connection conMethod() throws ClassNotFoundException, DBException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
			// con=DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE","soundarya","soundarya");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_CON);
		}

		System.out.println("connected");
		return con;
	}

}
