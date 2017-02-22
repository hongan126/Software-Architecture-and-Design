package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.BenhNhan;

public class DataQuerry {

	private DataQuerry() {
		new DataQuerry();
	}
	
	public static boolean dataUpdate(BenhNhan bn, String ndKham) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DataConnect.getConnection();
			String querry = "INSERT INTO KhamBenh(msbacsi,msbn,ngaykham,ghichu) VALUES(?,?,?,?)" ;
			stmt = con.prepareStatement(querry);
			stmt.setString(1, "abc");
			stmt.setString(2, bn.getMasoBN());
			stmt.setDate(3, DateConvert.convertJavaDateToSqlDate(new Date()));
			stmt.setString(4, ndKham);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi không truy cập được CSDL Bệnh viện");
		}
		
		return false;
	}
}
