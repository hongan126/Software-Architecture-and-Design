package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;


public class DataConnect {
	private static Connection con1=null;
		
		private DataConnect() {
			Properties pro = new Properties();
			File file = new File(".\\Properties.properties") ;
			if(file.exists())
			{
				try {
					pro.load(new FileInputStream(file));
					String url = pro.getProperty("URL_SQLSERVER");
					String user = pro.getProperty("USER_SQLSERVER");
					String pass = pro.getProperty("PASSWORD_SQLSERVER");
					con1 = DriverManager.getConnection(url,user,pass);
				} catch (IOException | SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sỡ dữ liệu");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sỡ dữ liệu");
			}
		}
		
		public static Connection getConnection(){
			if(con1 == null)
				new DataConnect();
			return con1;
		}
}
