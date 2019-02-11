package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlConnectionImpl  {

    private static SqlConnectionImpl instance = null;
    private Connection connection = null;

    public Connection connect() {

        int retries =10;
        for(int i =0; i < retries; i++){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "Semgroup16");
                System.out.println("Connection Established");
                Thread.sleep(10000);
                break;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        return  connection;
    }


    public List<String> command(String command) {

        List<String> serverResponse = new ArrayList<>();

        Statement stmt;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = connection;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(command);
            String tempResult;

            while (rs.next()) {

                tempResult = "";
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (!tempResult.equals("")) {
                        tempResult += ',';
                    }
                    tempResult += rs.getString(i);

                }
                serverResponse.add(tempResult);


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    return serverResponse;
    }
    public void CloseConnection() {

    }

    private SqlConnectionImpl(){
        connect();
    }

    public static SqlConnectionImpl getInstance(){
        if (instance == null){
            instance = new SqlConnectionImpl();
        }
        return instance;
    }
}