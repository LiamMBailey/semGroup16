package com.napier.sem.sqlserver;
import java.sql.*;

/*
 * SQL SERVER SINGLETON CLASS
 * CONNECTS TO DOCKER DB
 */
public class SqlServerConnection{
    /*
     * Establishes the connection with the docker MYSQL DB
     * Access level public as connection may need to be terminated and recreated
     */
    public Connection connect(String location) {
         Connection con = null;
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
        //Loops 10 times to establish the connection, throws error if it still cant connect
        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database.");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "Semgroup16");
                System.out.println("Successfully connected.");
                break;
            } catch (SQLException e) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(e.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

        return con;
    }
    /* A method to gracefully terminate the connection with the Connection
     * Access level public as connection may need to be terminated and recreated
     */
    public void Disconnect(Connection con) {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

}

