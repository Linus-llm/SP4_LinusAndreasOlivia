package org.oliviasFX;
import java.sql.*;

import java.sql.Connection;

public class DBConnector {
    int count;
    public Connection conn;
    TextUI ui = new TextUI();
    public void connect(String url){
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("connection establsihed");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());

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
    public void checkIfUsernameExistsAndPutIntoDB(String username, String password){
        String sql = "SElECT COUNT(*) FROM Users WHERE username = '"+username+ "'";
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                count = rs.getInt(1);
            }
            if(count<1){
                String sql1 = "INSERT INTO Users (username, Password) VALUES('"+username+"','"+password+"')";
                Statement stat1 = conn.createStatement();
                stat1.execute(sql1);
            } else{
                username = ui.promptText("Username eksisterer allerede prøv igen: ");
                password = ui.promptText("Indtast password: ");
                checkIfUsernameExistsAndPutIntoDB(username,password);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void checkIfCredentialsMatch(String username, String password){
        String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
       try{
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Du er logget ind!");
        } else {
            username = ui.promptText("Fejl, tast username igen: ");
            password = ui.promptText("Tast password'et igen: ");
            checkIfCredentialsMatch(username, password);
        }
       }catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

}