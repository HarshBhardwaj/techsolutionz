package threesixtyfivetech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	private static ConnectionManager dbInstance;
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String SQCONN = "jdbc:sqlite:techsolutionz.db";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("org.sqlite.JDBC");
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
