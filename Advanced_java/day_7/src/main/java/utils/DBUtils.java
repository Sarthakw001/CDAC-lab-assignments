package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	// add a method to open n ret a FIXED db cn
	public static Connection openConnection() throws SQLException {
	
		cn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true", "root", "1234");
		return cn;
	}
	// add a method to close DB connection
	public static void closeConnection() throws SQLException
	{
		if(cn != null)
			cn.close();
	}
	//add a getter for connection
	public static Connection getCn() {
		return cn;
	}
	

}
