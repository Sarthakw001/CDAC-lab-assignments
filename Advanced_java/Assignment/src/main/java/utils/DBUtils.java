package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	public static Connection openConnection() throws /* ClassNotFoundException, */ SQLException {
		cn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/VotingSystem?useSSL=false&allowPublicKeyRetrieval=true", "root",
				"2506#Sart");
		return cn;
	}

	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
	}

}
