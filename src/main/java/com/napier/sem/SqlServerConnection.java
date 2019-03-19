package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* SQL SERVER SINGLETON CLASS
* CONNECTS TO DOCKER DB
 */
public class SqlServerConnection {
    private Connection con = null;

    /* Automatically called on startup by the private constructor
    * Establishes the connection with the docker MYSQL DB
    * Access level public as connection may need to be terminated and recreated
    */
    public void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        //Loops 10 times to establish the connection, throws error if it still cant connect
        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+location+"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "Semgroup16");
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

    /* A method to gracefully terminate the connection with the Connection
     * Access level public as connection may need to be terminated and recreated
     */
    public void Disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

     /* A method that takes in a string which is a SQL statement
     * Then the SQL server is called with the given SQL statement
     * Returns an Arraylist of String
     */
    public List<String> command(String sql){

        List<String> serverResponse = new ArrayList<>();
        Statement stmt = null;

        if(sql.equals(null)){
            return serverResponse;
        }
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            StringBuilder sqlColumns = new StringBuilder();

            //Append the column names to the list that is returned
            for(int i =0; i < rsmd.getColumnCount(); i++){
                if(!sqlColumns.toString().equals("")){
                    sqlColumns.append(",");
                }
                sqlColumns.append(rsmd.getColumnLabel(i+1));


            }

            serverResponse.add(sqlColumns.toString());

            //Appends each row returned by the server to the list that is to be returned
            while (rs.next()){
               StringBuilder tempResult = new StringBuilder();

               for(int i = 0; i <rsmd.getColumnCount(); i++){
                   if(!tempResult.toString().equals("")){
                       tempResult.append(",");
                   }
                   tempResult.append(rs.getString(i+1));
               }
               serverResponse.add(tempResult.toString());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }



        return serverResponse;
    }

    public SqlServerConnection(){

    }


}
