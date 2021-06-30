package exec;

import com.Game;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ExecuteGame {
    public List<Game> getGame(){
        List<Game> listGame = new ArrayList<>();
        String query = "select * from game";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Game gm = new Game();
                gm.setId_game(rs.getInt("id_game"));
                gm.setJudul(rs.getString("judul"));
                gm.setGenre(rs.getString("genre"));
                gm.setHarga(rs.getInt("harga"));
                listGame.add(gm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listGame;
    }
    
    public int insertgame(Game gm){
        int hasil = 0;
        String query = "Insert into game(id_game, judul, genre, harga)"
                + "value("+ gm.getId_game()+",'"+ gm.getJudul()+"','"+gm.getGenre()+"',"+ gm.getHarga()+")";
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
    
    public int deletegame(int delId_game){
        int hasil = 0;
        String query = "delete from game where id_game='"+ delId_game+"'";
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
    
    public int updategame(Game newgm){
        int hasil = 0;
        String query = "update game set judul='"+ newgm.getJudul()+"',harga="+ newgm.getHarga() +", genre = '"+ newgm.getGenre()+ "' where id_game = '"+
                newgm.getId_game() + "'";
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
