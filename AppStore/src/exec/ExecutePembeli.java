package exec;

import com.Pembeli;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecutePembeli {
    public List<Pembeli> getPembeli(String username, String password){
        List<Pembeli> listPembeli = new ArrayList<>();
        String query;
        if(username == null && password == null){
            query = "select * from pembeli";
        }else{
            query = "select * from pembeli where username='" +username+ "' and password ='"+password+"'";
        }
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pembeli pm = new Pembeli();
                pm.setId_pembeli(rs.getInt("id_pembeli"));
                pm.setUsername(rs.getString("username"));
                pm.setPassword(rs.getString("password"));
                pm.setNama(rs.getString("nama"));
                pm.setAlamat(rs.getString("alamat"));
                pm.setEmail(rs.getString("email"));
                pm.setNo_hp(rs.getString("no_hp"));
                listPembeli.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listPembeli;
    }
    
    public int insertpembeli(Pembeli pm){
        int hasil = 0;
        String query = "Insert into pembeli(id_pembeli, username, password, nama, alamat, email, no_hp)"
                + "value("+ pm.getId_pembeli()+",'"+ 
                pm.getUsername()+"','"+ pm.getPassword()+"','"+pm.getNama()+"','"+pm.getAlamat()+
                "','"+ pm.getEmail()+"','"+ pm.getNo_hp()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int deletepembeli(int delId_pembeli){
        int hasil = 0;
        String query = "delete from pembeli where id_pembeli='"+ delId_pembeli+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int updatepembeli(Pembeli newpm){
        int hasil = 0;
        String query = "update pembeli set username='"+newpm.getUsername()+"',password='"+ newpm.getPassword()+ "',nama='"+ 
                newpm.getNama() +"',alamat='"+ newpm.getAlamat() +"', email = '"+ newpm.getEmail()+"', no_hp = '"
                + newpm.getNo_hp()+ "' where id_pembeli = '"+
                newpm.getId_pembeli() + "'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }  
}
