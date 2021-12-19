package ConnectionOracl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOracl {
    private static Connection con;

    static{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Drive OK");
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","miniProjet","123456");
            System.out.println("connection DB OK");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon() {
        return con;
    }
}