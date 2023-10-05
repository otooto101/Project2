package Utils.DatabaseUtils;

import Data.User;

import java.sql.*;

public class DbUsers {
    static Connection connection = DbConnection.getConnection();
    static ResultSet resultSet;

    public static void reconnect(){
        connection = DbConnection.getConnection();
    }

    public static void insertData() {
        String insertQuery = "INSERT INTO users.dbo.users (firstName,lastName,phone,email,dateOfBirth,password) "
                + "VALUES(?,?,?,?,?,?)";
        try (
                PreparedStatement pstmt = connection.prepareStatement(insertQuery);
        ) {
            pstmt.setString(1, User.firstName );
            pstmt.setString(2, User.lastName);
            pstmt.setString(3, User.phone);
            pstmt.setString(4, User.email);
            pstmt.setString(5, User.dateOfBirth);
            pstmt.setString(6, User.password);
            pstmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void getResultsSet(){
        try {
            Statement stm = connection.createStatement();
            String query = "select * from users.dbo.users;";
            resultSet = stm.executeQuery(query);
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getFirstName(){
        try {
            return resultSet.getString("firstName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLastName(){
        try {
            return resultSet.getString("lastName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPhone(){
        try {
            return resultSet.getString("phone");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getEmail(){
        try {
            return resultSet.getString("email");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateOfBirth(){
        try {
            return resultSet.getString("dateOfBirth");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPassword(){
        try {
            return resultSet.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void truncateTable(){
        String deleteQuery = "TRUNCATE TABLE users.dbo.users";
        try {
            PreparedStatement deleteStm = connection.prepareStatement(deleteQuery);
            deleteStm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
