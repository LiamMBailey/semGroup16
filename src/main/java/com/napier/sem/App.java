package com.napier.sem;

import java.io.Console;
import java.sql.*;

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

        /*
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
        */



        String input = "";
        Console console = System.console();

        while(!input.equals("EXIT")){
            System.out.println("Enter SQL statement(EXIT to finish)");
            input = console.readLine();

            if(input.equals("EXIT")){
                System.out.println("App closing");
                continue;
            }
            else {
                try {
                    /**
                    * Based on https://stackoverflow.com/questions/24229442/java-print-the-data-in-resultset
                    * Answer by Zeb 27/01/2015
                     *
                     * Print data row after row in format "record1 column_name1, record2 column_name2,(...)"
                    * */
                    Statement statement = a.con.createStatement();
                    ResultSet resultSet = statement.executeQuery(input);
                    ResultSetMetaData rsmd = resultSet.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) System.out.print(",  ");
                            String columnValue = resultSet.getString(i);
                            System.out.print(columnValue + " " + rsmd.getColumnName(i));
                        }
                        System.out.println("");
                    }
                    System.out.println("Operation successful");
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Operation failed");
                }
            }
        }



    }

}