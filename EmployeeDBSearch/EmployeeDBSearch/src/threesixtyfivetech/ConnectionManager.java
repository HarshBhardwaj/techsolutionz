//package threesixtyfivetech;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectionManager{
//	private static ConnectionManager dbInstance;
//	private static String driverName = "com.mysql.jdbc.Driver";
//	private static String url = "jdbc:mysql://127.0.0.1:3306/employee_schema";
//	private static String user = "root";
//	private static String pass = "AAAbbb444$";
//	private static Connection con;
//	
//	public Connection getConnection() {
//		try {
//			Class.forName(driverName);
//			try {
//				con = DriverManager.getConnection(url, user, pass);
//			} catch (SQLException e) {
//				System.out.println("Failed to create the database connection.");
//			}
//		} catch (ClassNotFoundException e) {
//			System.out.println("Driver not found.");
//		}
//		return con;
//	}
//	
//	public static ConnectionManager getInstance() {
//		if (dbInstance == null) {
//			dbInstance = new ConnectionManager();
//		}
//		return dbInstance;
//	}
//	
//	public static void closeConn(Connection con) {
//		try {
//			con.close();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//		
//	}
//}
package threesixtyfivetech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	private static ConnectionManager dbInstance;
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN = "jdbc:mysql://localhost/login";
	private static final String SQCONN = "jdbc:sqlite:schoolsystem.sqlite";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("org.sqllite.JDBC");
			return DriverManager.getConnection(SQCONN);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ConnectionManager getInstance() {
		if (dbInstance == null) {
			dbInstance = new ConnectionManager();
		}
		return dbInstance;
	}
	
	public static void closeConn(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}	
	}
}
