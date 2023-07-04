package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String USER_DB = "root";
    private static final String USER_PWD = "";
    private static final String USER_URL = "jdbc:mysql://localhost:3307/classicmodels";


    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(USER_URL, USER_DB, USER_PWD);
            System.out.println(con + " is open");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }


    public static void release(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println(con + " is closed");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

