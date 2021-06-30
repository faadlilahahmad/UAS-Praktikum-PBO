/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Transaksi;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faadlilah Ahmad Purwanto
 */
public class ExecuteTransaksi {
    public List<Transaksi> getTransaksi(){
        List<Transaksi> listTransaksi = new ArrayList<>();
        String query = "select transaksi.id_transaksi,transaksi.tgl_transaksi,transaksi.id_game, "
                + "transaksi.id_supplier,transaksi.id_pembeli,pembeli.nama,game.judul "
                + "from transaksi,pembeli,game "
                + "WHERE transaksi.id_pembeli=pembeli.id_pembeli and transaksi.id_pembeli = game.id_game";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaksi ts = new Transaksi();
                ts.setId_transaksi(rs.getInt("transaksi.id_transaksi"));
                ts.setTgl_transaksi(rs.getString("transaksi.tgl_transaksi"));
                ts.setId_game(rs.getInt("transaksi.id_game"));
                ts.setfknamagame(rs.getString("game.judul"));
                ts.setId_pembeli(rs.getInt("transaksi.id_pembeli"));
                ts.setFknamapembeli(rs.getString("pembeli.nama"));
                ts.setId_supplier(rs.getInt("transaksi.id_supplier"));
                listTransaksi.add(ts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listTransaksi;
    }
    
    public int inserttransaksi(Transaksi ts){
        int hasil = 0;
        String query = "Insert into transaksi(id_transaksi, tgl_transaksi, id_game, id_pembeli, id_supplier)"
                + "value("+ ts.getId_transaksi()+",'"+ ts.getTgl_transaksi()+"',"+ts.getId_game()+","+ ts.getId_game()
                +","+ts.getId_supplier()+")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}
