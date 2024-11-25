package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        //Statement myStmt = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc;encrypt=true;trustServerCertificate=true;";
        String user = "student";
        String pass = "student";


        try {
            myConn = DriverManager.getConnection(url, user, pass);

            System.out.println("connection successful!");

           // myStmt = myConn.createStatement();

            //insert new employee
            System.out.println("insert new employee");

//            int rowsAffected = myStmt.executeUpdate(
//                    "USE jdbc;" +
//                            "INSERT INTO employees (last_name, first_name, email, department, salary)" +
//                            "VALUES ('Jackson', 'sam', 'sam.jackson@mail.com', 'IT', 14000);");
            //updating a record
//            int rowsAffected = myStmt.executeUpdate(
//                    "USE jdbc;" +
//                            "UPDATE employees SET last_name = 'Jackson', first_name = 'Sam', email = 'sam.jackson@mail.com', department = 'IT', salary = 15000 " +
//                            "WHERE id = 1004;");
            // deleting a record
//            int rowsAffected = myStmt.executeUpdate(
//                    "USE jdbc;" +
//                            "DELETE from employees WHERE  last_name = 'Jackson' AND first_name = 'sam'");

            //prepared statements
//            myStmt = myConn.prepareStatement("SELECT * from employees WHERE salary > ? and department=?");
//            myStmt.setDouble(1,40000);
//            myStmt.setString(2,"IT");
//            myRs = myStmt.executeQuery();
//
//            //myRs = myStmt.executeQuery("select * from employees order by last_name");
//
//            //process result set
//            while (myRs.next()){
//                System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name") + " " + myRs.getString("department") +  " " + myRs.getString("salary"));
//            }

            //CALLING STORED PROCEDURES
            myStmt = myConn.prepareCall("{call increase_salary_by_department(?,?)}");
            myStmt.setString(1,"IT");
            myStmt.setInt(2,1000);
            myStmt.execute();



        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

    }

}