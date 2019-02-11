package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "Semgroup16");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }


    public static void main(String[] args) {

//        System.out.println("Initialized");
//        SqlConnectionImpl sqlServer =  SqlConnectionImpl.getInstance();
//
//        List<String> serverResponse;
//        serverResponse =sqlServer.command("Select name From City");
//
//        for (String s: serverResponse){
//            System.out.println(s);
//        }
//        System.out.println("Finished");
//    }
        App a = new App();
        a.connect();

        try {
            Statement stmt = a.con.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT city.name,city.population FROM city JOIN country ON city.CountryCode = country.Code WHERE city.population > 100000 ORDER BY city.population");
            while(rset.next()){
                System.out.println(rset.getString("name"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Operation successful");

        //Input Test
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        String age = scanner.nextLine();
        System.out.println(age);




    }

}