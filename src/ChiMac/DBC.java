package ChiMac;

import java.sql.*;

public class DBC {

		public static Connection DBConnect() {

			Connection con = null;
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			// 접속할 DB의 계정정보(차후 변경)
			String user = "WUSJUSTDOIT";
			String password = "1111";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url,user,password);
						
			} catch (ClassNotFoundException cne) {
				cne.printStackTrace();
				System.out.println("DB접속 실패 : 드라이버 로딩 실패!");
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("DB접속 실패 : 계정정보 확인!");
			} 
			return con;
		}
}
