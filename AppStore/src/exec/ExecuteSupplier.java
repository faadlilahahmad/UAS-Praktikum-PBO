package exec;

import com.Supplier;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteSupplier {
    public List<Supplier> getSupplier(){
        List<Supplier> listSupplier = new ArrayList<>();
        String query = "select * from supplier";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Supplier sp = new Supplier();
                sp.setId_supplier(rs.getInt("id_supplier"));
                sp.setNama(rs.getString("nama"));
                sp.setAlamat(rs.getString("alamat"));
                sp.setEmail(rs.getString("email"));
                sp.setNo_hp(rs.getString("no_hp"));
                listSupplier.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listSupplier;
    }
    
    public int insertsupplier(Supplier sp){
        int hasil = 0;
        String query = "Insert into supplier(id_supplier, nama, alamat, email, no_hp)"
                + "value("+ sp.getId_supplier()+",'"+ 
                sp.getNama()+"','"+ sp.getAlamat()+"','"+sp.getEmail()+"','"+ sp.getNo_hp()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int deletesupplier(int delId_supplier){
        int hasil = 0;
        String query = "delete from supplier where id_supplier='"+ delId_supplier+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int updatesupplier(Supplier newsp){
        int hasil = 0;
        String query = "update supplier set nama='"+newsp.getNama()+"',alamat='"+ newsp.getAlamat()+ "',email='"+ 
                newsp.getEmail() +"',no_hp='"+ newsp.getNo_hp() + "' where id_supplier = '"+ newsp.getId_supplier() + "'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}
