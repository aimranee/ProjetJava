package ConnectionOracl; 
import java.sql.*;

public class Connect {
	
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print(" Driver ok | ");
			con=DriverManager.getConnection("jdbc:mysql://localhost/miniprojetjbm","root","");
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
