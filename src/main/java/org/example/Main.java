package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc;encrypt=true;trustServerCertificate=true;";
        String user = "student";
        String pass = "student";


        try {
            myConn = DriverManager.getConnection(url, user, pass);

            System.out.println("connection successful!");

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("select * from employees");

            while (myRs.next()){
                System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

    }

}