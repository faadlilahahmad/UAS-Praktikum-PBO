package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/oop_game"; 
    private String username = "root";       
    private String password = "";    

    public Connection logOn(){
        try {
            Class.forName( driver ).newInstance();
            con = DriverManager.getConnection( url, username, password );
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
        }
        return con;
    }

    public void logOff(){
        try {
            con.close();
        }
        catch(SQLException ex){
        }
    }
}

