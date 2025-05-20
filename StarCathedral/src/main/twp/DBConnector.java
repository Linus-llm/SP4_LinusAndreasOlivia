package twp;
import java.sql.*;

import java.sql.Connection;

public class DBConnector {
    int count;
    public Connection conn;
    TextUI ui = new TextUI();
    public void connect(String url){
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connection fejlet: " + e.getMessage());

        }
    }


    public void checkIfUsernameExistsAndPutIntoDB(String username, String password){
        String sql = "SElECT COUNT(*) FROM Users WHERE username = '"+username+ "'";
        Statement stat = null;
        Statement stat1 = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                count = rs.getInt(1);
            }
            if(count<1){
                String sql1 = "INSERT INTO Users (username, Password) VALUES('"+username+"','"+password+"')";
                stat1 = conn.createStatement();
                stat1.execute(sql1);
            } else{
                username = ui.promptText("Username eksisterer allerede prøv igen: ");
                password = ui.promptText("Indtast password: ");
                checkIfUsernameExistsAndPutIntoDB(username,password);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            // close in reverse order
            try {
                if (rs != null) rs.close();
                if (stat != null) stat.close();
                if (stat1 != null) stat.close();
            } catch (SQLException e) {
                System.out.println("Fejl slutter: " + e.getMessage());
            }
        }

    }
    public void checkIfCredentialsMatch(String username, String password){
        String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        Statement stat = null;
        ResultSet rs = null;
       try{
        stat = conn.createStatement();
        rs = stat.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Du er logget ind!");
            System.out.println(" ");
        } else {
            username = ui.promptText("Fejl, tast username igen: ");
            password = ui.promptText("Tast password'et igen: ");
            checkIfCredentialsMatch(username, password);
        }
       }catch (SQLException e) {
           System.out.println(e.getMessage());
       }finally {
           // close in reverse order
           try {
               if (rs != null) rs.close();
               if (stat != null) stat.close();

           } catch (SQLException e) {
               System.out.println("Fejl slutter: " + e.getMessage());
           }
       }
    }
    public void saveHighscore(String username, long timeInSeconds){
        String sql = "SELECT Highscore FROM Users WHERE username = '"+ username +"'";
        ResultSet rs = null;
        Statement stat = null;
        Statement stat1 = null;
        Statement stat2 = null;
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()){
                long existingTime = rs.getLong("Highscore");

                if (rs.wasNull()) {
                    String sql3 = "UPDATE Users SET Highscore = '" + timeInSeconds + "' WHERE username = '" + username + "'";
                    stat1 = conn.createStatement();
                    stat1.executeUpdate(sql3);
                    System.out.println("Første highscore!");
                }else if(timeInSeconds<existingTime){
                    String sql1 = "UPDATE Users SET Highscore = '"+ timeInSeconds +"' WHERE username = '"+ username +"'";
                    stat1 = conn.createStatement();
                    stat1.executeUpdate(sql1);
                    System.out.println("Ny highscore!");
                }else {
                    System.out.println("Ingen ny highscore");
                }

        } else {
                String sql2 = "INSERT INTO Users (username, Highscore) VALUES('"+username+"','"+timeInSeconds+"')";
                stat2 = conn.createStatement();
                stat2.execute(sql2);
                System.out.println("Ny highscore gemt");
            }

            }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            // close in reverse order
            try {
                if (rs != null) rs.close();
                if (stat != null) stat.close();
                if (stat1 != null) stat1.close();
                if (stat2 != null) stat2.close();
            } catch (SQLException e) {
                System.out.println("Fejl slutter " + e.getMessage());
            }
        }
    }

}