package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con = null;

	public ConnectDB() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKhamBenh;user=lldtien;"
					+ "password=thienthan");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection instance() {

		if (con == null)
			new ConnectDB();
		return con;

	}

	public static void Disconnect() {
		try {
			if (!con.isClosed())
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
