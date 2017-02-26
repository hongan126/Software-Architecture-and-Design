package Databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.BenhNhan;

public class BenhNhanDAO {
	public static boolean InsertBenhNhan(BenhNhan bn) {
		if (FindBenhNhanById(bn.getMsbn()) == null && FindBenhNhanByCMND(bn.getSocmnd()) == null) {
			Statement statement = null;
			try {
				statement = ConnectDB.instance().createStatement();
				String insert = "insert into benhnhan values('" + bn.getMsbn() + "','" + bn.getSocmnd() + "','"
						+ bn.getHoten() + "','" + bn.getDiachi() + "')";
				statement.executeUpdate(insert);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (statement != null)
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			return true;
		}
		return false;
	}

	public static BenhNhan FindBenhNhanById(String id) {
		String query = "select * from benhnhan where msbn = " + "'" + id + "'";
		Statement statement = null;
		BenhNhan bn = null;
		try {
			statement = ConnectDB.instance().createStatement();
			ResultSet re = statement.executeQuery(query);
			if (re.next()) {
				bn = new BenhNhan();
				bn.setMsbn(re.getString(1));
				bn.setSocmnd(re.getString(2));
				bn.setHoten(re.getString(3));
				bn.setDiachi(re.getString(4));
				System.out.println("BenhNhan id not null");
				return bn;
			}
			System.out.println("BenhNhan id is null");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	public static BenhNhan FindBenhNhanByCMND(String socmnd) {
		System.out.println("socmnd = " + socmnd);
		String query = "select * from benhnhan where socmnd = " + "'" + socmnd + "'";
		Statement statement = null;
		BenhNhan bn = null;
		try {
			statement = ConnectDB.instance().createStatement();
			ResultSet re = statement.executeQuery(query);
			if (re.next()) {
				bn = new BenhNhan();
				bn.setMsbn(re.getString(1));
				bn.setSocmnd(re.getString(2));
				bn.setHoten(re.getString(3));
				bn.setDiachi(re.getString(4));
				System.out.println("BenhNhan cmnd not null");
			}
			System.out.println("BenhNhan cmnd is null");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bn;
	}
}
