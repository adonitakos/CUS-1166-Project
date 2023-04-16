/* Project: Vehicle Vortex
*  Class: DBConnection.java
*  Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: April 16th, 2023 
*  This program creates and returns a database connection.
*/

import java.sql.*;

public class DBConnection {
	private static Connection conn = null;
	private static String dbString = "jdbc:mysql://localhost:3306/";
	private static String userName = "root";
	private static String password = "password";
	public static String winflag = "?useSSL=false";
	public static String dbname;


	public static void setDBName(String db) {
		dbname = db;
	}

	/**
	 * initialize with the name of the database the rest of the connection
	 * information is hardcoded
	 * 
	 * @param dbn database name
	 * @throws ClassNotFoundException
	 */
	public static void init(String dbn) throws ClassNotFoundException {
		dbname = dbn;
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	/**
	 * return a database connection
	 * 
	 * @return
	 * @throws SQLException if the connection cannot be created
	 */
	public static Connection getMyConnection() throws SQLException {
		if (conn == null) {
			String fullDBString = dbString + dbname + winflag;
			conn = DriverManager.getConnection(fullDBString, userName, password);
		}
		return conn;
	}

}