package com.napier.sem.sqlserver;

import com.napier.sem.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServerQuery {
    static Connection con = null;
    public List<?> query(String sql, String returnType){
        List<?> serverResponse = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultMD = resultSet.getMetaData();

            if(returnType.equals("String")){
                serverResponse = stringQuery(resultSet,resultMD);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return serverResponse;
    }
    private List<String> stringQuery(ResultSet rs, ResultSetMetaData rsmd){
        List<String> serverResponse = new ArrayList<>();
        try{
            while (rs.next()){
                StringBuilder tempResult = new StringBuilder();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (!tempResult.toString().equals("")) {
                        tempResult.append("::");
                    }
                    tempResult.append(rs.getString(i + 1));
                }
                serverResponse.add(tempResult.toString());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return serverResponse;
    }

    private List<Country> CountryQuery(ResultSet rs){
        List<Country> serverResponse = new ArrayList<>();
        try{
            while (rs.next()){
                Country c = new Country();
                c.setCountryCode(rs.getString("Code"));
                c.setCountryName(rs.getString("Name"));
                c.setCountryRegion(rs.getString("Region"));
                c.setCountryContinent(rs.getString("Continent"));
                c.setCountryPopulation(Integer.parseInt(rs.getString("Population")));
                c.setCountryCapital(rs.getString("Capital"));

                serverResponse.add(c);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return serverResponse;
    }

    public SqlServerQuery(Connection connection){
        con = connection;
    }

}
