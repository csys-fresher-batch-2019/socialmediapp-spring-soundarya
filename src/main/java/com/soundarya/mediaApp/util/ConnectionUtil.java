package com.soundarya.mediaApp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

		// con=DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE","soundarya","soundarya");

		System.out.println("connected");
		return con;
	}

}
