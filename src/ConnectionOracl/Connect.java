package ConnectionOracl; 
import java.sql.*;

public class Connect {
	
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.print(" Driver ok ");
			con=DriverManager.getConnection("jdbc:mysql://localhost/miniprojetjbm","root","");
//			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","miniProjet","123456");
			System.out.println("connexion ok");
		} catch (ClassNotFoundException e1) {
			System.out.println("Problème au niveau du pilote1");
		}catch (SQLException e) {
			System.out.println("Problème au niveau du SQL EXCEPTION");
		}
	}
	public static Connection getCon(){
		return con;
	}
	
}
