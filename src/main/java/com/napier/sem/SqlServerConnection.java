package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlServerConnection {
    private static SqlServerConnection instance = null;
    private Connection con = null;

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

    public List<String> command(String sql){

        List<String> serverResponse = new ArrayList<>();
        Statement stmt = null;
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            StringBuilder sqlColumns = new StringBuilder();

            for(int i =1; i < rsmd.getColumnCount(); i++){

                if(!sqlColumns.toString().equals("")){
                    sqlColumns.append(",");
                }
                sqlColumns.append(rsmd.getColumnLabel(i));


            }

            serverResponse.add(sqlColumns.toString());

            while (rs.next()){
               StringBuilder tempResult = new StringBuilder();

               for(int i = 0; i <rsmd.getColumnCount(); i++){
                   if(!tempResult.toString().equals("")){
                       tempResult.append(",");
                   }
                   tempResult.append(rs.getString(i));
               }
               serverResponse.add(tempResult.toString());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }



        return serverResponse;
    }

    private SqlServerConnection(){
        connect();
    }

    public static SqlServerConnection getInstance(){
        if (instance == null){
            instance = new SqlServerConnection();
        }
        return instance;
    }

}
