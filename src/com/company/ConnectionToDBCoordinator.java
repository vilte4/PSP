package com.company;

import java.sql.*;

public class ConnectionToDBCoordinator {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "";
    static final String PASS = "";

    public static Connection openConnection() {
        Connection connection = null;
        Statement stmt = null;
        try {

            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void selectUser(int userId) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "SELECT vardas, pavarde, telefono_numeris, email FROM USER where ID = " + userId + "";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print("Vardas: " + rs.getString("Vardas") + "\n");
                System.out.print("Pavarde: " + rs.getString("Pavarde") + "\n");
                System.out.print("Telefono numeris: " + rs.getString("Telefono_numeris") + "\n");
                System.out.println("Elektroninio pasto adresas: " + rs.getString("Email"));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(User user) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO USER (vardas, pavarde, telefono_numeris, email, adresas, slaptazodis)  " + "VALUES ('" + user.firstName + "', '" + user.lastName + "', '" + user.phoneNumber + "', '" + user.email + "', '" + user.address + "', '" + user.password + "' )";

            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection, stmt);
    }

    public static void deleteUser(int userId) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM USER where ID = " + userId + "";

            stmt.executeUpdate(sql);

            System.out.println("User by ID: " + userId + " record was deleted...");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection(connection, stmt);
    }

    public static void editPhoneNumber(int userId, String newPhoneNumber) {
        Connection connection = openConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            String sql = "UPDATE USER " + "SET telefono_numeris = '" + newPhoneNumber + "' WHERE ID =" + userId + "";

            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
