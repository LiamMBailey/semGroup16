package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlConnectionImpl implements SqlConnectionInterface {

    private static SqlConnectionImpl instance = null;
    private Connection connection = null;
    @Override
    public Connection connect() {

        int retries =10;
        for(int i =0; i < retries; i++){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "Semgroup16");
                break;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return  connection;
    }

    @Override
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

    @Override
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
