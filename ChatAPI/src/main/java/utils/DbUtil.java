package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil {
	private static DataSource ds;

		public static Connection getConn() throws SQLException {
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/chatrepo?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "coderslab");
		

	}

//	private static DataSource getInstance() {
//		if (ds == null) {
//			try {
//				Context ctx = new InitialContext();
//				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/school");
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//		}
//		return ds;
//	}
}
