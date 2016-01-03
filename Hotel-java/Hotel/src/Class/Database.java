/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author eyubonsai
 */
public class Database {
     public static String PathReport=System.getProperty("user.dir") + "/src/Laporan/";
    private static Connection koneksi;
    public static Connection getkoneksi(String host,String usr,String pwd,String db) {
        if (koneksi==null) {
            try {
                String url=new String();
                url="jdbc:mysql://" + host + ":3306/" + db;
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url,usr,pwd);
            }catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
     return koneksi;
    }
}
