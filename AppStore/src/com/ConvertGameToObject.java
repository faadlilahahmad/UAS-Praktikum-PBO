package com;
import exec.ExecuteGame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ConvertGameToObject {
    private String url = "jdbc:mysql://localhost:3306/oop_game"; 
    private String username = "root";       
    private String password = "";
    public String[][] getGame(){
        List<Game> myGm = new ArrayList<Game>();
        ExecuteGame eGm = new ExecuteGame();
        myGm = eGm.getGame();
        String[][] dataGame = new String[myGm.size()][4];
        int i=0;
        for(Game gm : myGm){
            dataGame[i][0] = ""+gm.getId_game();
            dataGame[i][1] = gm.getJudul();
            dataGame[i][2] = gm.getGenre();
            dataGame[i][3] = ""+gm.getHarga();
            i++;
        }
        return dataGame;
    }

public ResultSet SearchTextJudul (String judul)throws SQLException{ 
    Connection con = DriverManager.getConnection(url, username,password) ;
    String sql = "select * from game where judul like ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, judul);
    ResultSet rs = pst.executeQuery();
    return rs;
}
 public ResultSet SearchTextGenre (String genre)throws SQLException{ 
    Connection con = DriverManager.getConnection(url, username,password) ;
    String sql = "select * from game where genre like ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, genre);
    ResultSet rs = pst.executeQuery();
    return rs;
}
}
