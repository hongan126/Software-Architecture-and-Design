package Databases;

import java.sql.Statement;

import Models.KhamBenh;

public class KhamBenhDAO {
	public static void SaveKhamBenhToDTB(KhamBenh kb) {
		try {
			String q = "insert into khambenh(msbn,msbacsy,ngaykham,ghichu) values ('" + kb.getMsbn() + "','" + kb.getMsbacsy()
					+ "','" + kb.getNgaykham() + "','" + kb.getGhichu() + "')";
			Statement statement = ConnectDB.instance().createStatement();
			statement.executeUpdate(q);
			statement.close();
		} catch (Exception e) {
			System.out.println("Khong the kham 2 lan trong 1 ngay trong cung 1 bac si");
		}
	}
}
