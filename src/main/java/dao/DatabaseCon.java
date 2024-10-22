package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {



    public static Connection getConncetion(){
    Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myhiber", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();

        }


        return con;
    }

}
