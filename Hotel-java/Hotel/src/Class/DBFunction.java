/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author eyubonsai
 */
public class DBFunction {
  private DefaultTableModel model;
    public ResultSet r;
    public static String host="localhost";
    public static String usr="root";
    public static String pwd="";
    public static String dbs="hoteldb";
    private static Connection db;
    private static Connection koneksi;
    public static Connection getkoneksi() {
        if (koneksi==null) {
            try {                              
                String url="jdbc:mysql://"+host+":3306/"+dbs;
                String user=usr;
                String password=pwd;
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url,user,password);
            }catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
     return koneksi;
    }
   public static Connection OpenDB()
    {
         if (db==null) {
                                       
               db=Database.getkoneksi(host,usr,pwd,dbs);
           
         }
      // db=Database.getkoneksi(host,usr,pwd,dbs);
       // return db;
         return db;
        
    }
    
    public  void RunSQL(String sql)
    {        
        Connection db=OpenDB();
        try {
            try (PreparedStatement p = (PreparedStatement) db.prepareStatement(sql)) {
                p.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String _getPathReport()
{
    String p=new String();
    File f = new File(System.getProperty("user.dir") + "/src/Laporan/");
    if (f.exists())
       {
            p=System.getProperty("user.dir") + "/src/Laporan/";   
       }else{
        p=System.getProperty("user.dir") + "/Laporan/";
        }
    return p;
}
    public boolean _isBOF(String sql) throws SQLException
    {
        Connection db=OpenDB();
        Statement s= db.createStatement();
        try {
            //  String sql="Select * from tblPeminjaman where kd_pinjam='" + this.TxtKodePeminjaman.getSelectedItem() + "'";
              ResultSet r=s.executeQuery(sql);
              if(r.next())
              {
                  return false;
              }else{
                  return true;
              }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      return false;
                
    }
    
    public  String _LastID(String table) throws SQLException
    {
       
      Connection db=OpenDB();
        Statement s= db.createStatement();
        String value=new String();
        try {
            //  String sql="Select * from tblPeminjaman where kd_pinjam='" + this.TxtKodePeminjaman.getSelectedItem() + "'";
              ResultSet r=s.executeQuery("SHOW TABLE STATUS LIKE '"+table+"'");
              if(r.next())
              {
                  value=r.getString("Auto_increment");              
              }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
           
    }
    
    public String _getValue(String sql) throws SQLException
    {
       
      Connection db=OpenDB();
        Statement s= db.createStatement();
        String value=new String();
        try {
            //  String sql="Select * from tblPeminjaman where kd_pinjam='" + this.TxtKodePeminjaman.getSelectedItem() + "'";
              ResultSet r=s.executeQuery(sql);
              if(r.next())
              {
                  value=r.getString(1);              
              }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
           
    }
    
    public Date _getDate(String sql) throws SQLException
    {
       
      Connection db=OpenDB();
        Statement s= db.createStatement();
        Date value = null;
        try {
            //  String sql="Select * from tblPeminjaman where kd_pinjam='" + this.TxtKodePeminjaman.getSelectedItem() + "'";
              ResultSet r=s.executeQuery(sql);
              if(r.next())
              {
                  value=r.getDate(1);              
              }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
           
    }
        
    
    public  void _bindingCombo(String sql,JComboBox obj ,String output)
    {
        try {        
       obj.removeAllItems();
        
           Connection db=OpenDB();
            Statement s= db.createStatement();           
            ResultSet r=s.executeQuery(sql);
            
            while (r.next()) {
               obj.addItem(r.getString(output));
            }
            r.close();
            s.close();
        }catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public  void _bindingTable(String sql,JTable tabel)
    {
        try{       
        Connection db=OpenDB();
        Statement s= db.createStatement();           
        ResultSet r=s.executeQuery(sql);
     
        tabel.setModel(DbUtils.resultSetToTableModel(r));
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public  void _insertData(String tabel,String[] fields,String[] value)
    {
        Connection db=OpenDB();
         String implode1=Functions.implode("`,`", fields);
         String implode2=Functions.implode("','", value);
         String sql="Insert into `" + tabel + "` (`" + implode1 + "`) value ('" + implode2 + "')";
        try {
            try (PreparedStatement p = (PreparedStatement) db.prepareStatement(sql)) {
                p.executeUpdate();
           //     System.out.printf(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public  void _updateData(String table, Map<String, String> update_list, String condition){
     String query = "UPDATE " + table + " SET ";
    Connection db=OpenDB();
     try {
         query += Functions.implode3(",", update_list) + " " + condition;
            try (PreparedStatement p = (PreparedStatement) db.prepareStatement(query)) {
                p.executeUpdate();
           //     System.out.printf(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

      }

    public boolean r(String id_cat_quiz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
