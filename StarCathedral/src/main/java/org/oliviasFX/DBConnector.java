package org.oliviasFX;
import java.sql.*;

import java.sql.Connection;

public class DBConnector {
    Connection conn;
    public void connect(String url){
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectPlayers(){
        String sql = "SELECT * FROM Players";
        try {
            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()){
                String name = rs.getString("name");

                System.out.println(name);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getBalanceOfPlayers(String name){
        String sql = "SELECT balance FROM Players Where name = '" + name+"'";
        try{
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            int balance =  rs.getInt("balance");
            System.out.println(name + " , saldo: " + balance);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
    public void insertUserInfoToDatabase(String username, String password){

        String sql = "INSERT INTO Users (username,password) VALUES ('"+username+"',"+password+")";
        try {
            Statement stat = conn.createStatement();
            stat.execute(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
    }

}