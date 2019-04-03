package com.napier.sem.sqlserver;

import com.napier.sem.blueprints.CapitalCity;
import com.napier.sem.blueprints.City;
import com.napier.sem.blueprints.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServerQuery {
    static Connection con = null;

    public List<String> stringQuery(String sql) {
        List<String> serverResponse = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                StringBuilder tempResult = new StringBuilder();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (!tempResult.toString().equals("")) {
                        tempResult.append("::");
                    }
                    tempResult.append(rs.getString(i + 1));
                }
                serverResponse.add(tempResult.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return serverResponse;
    }

    public List<Country> CountryQuery(String sql) {
        List<Country> serverResponse = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Country c = new Country();
                c.setCountryCode(rs.getString("Code"));
                c.setCountryName(rs.getString("Name"));
                c.setCountryRegion(rs.getString("Region"));
                c.setCountryContinent(rs.getString("Continent"));
                c.setCountryPopulation(Integer.parseInt(rs.getString("Population")));
                String capital = stringQuery("SELECT name FROM city WHERE ID = "+rs.getString("Capital")).get(0);
                c.setCountryCapital(capital);

                serverResponse.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return serverResponse;

    }

    public List<City> cityQuery(String sql){
        List<City> serverResponse = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                City c = new City();
                c.setCityName(rs.getString("Name"));
                c.setCityDistrict(rs.getString("District"));
                c.setCityPopulation(Integer.parseInt(rs.getString("population")));
                String Country = stringQuery("Select name FROM country where code = "+rs.getString("CountryCode")).get(0);
                c.setCityCountry(Country);

                serverResponse.add(c);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }

        return serverResponse;
    }

    public List<CapitalCity> capitalCityQuery(String sql){
        List<CapitalCity> serverResponse = new ArrayList<>();

        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                CapitalCity c = new CapitalCity();
                c.setCapitalCityName(rs.getString(1));
                c.setCapitalCityCountry(rs.getString(2));
                c.setCapitalCityPopulation(Integer.parseInt(rs.getString(3)));

                serverResponse.add(c);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return serverResponse;
    }

    public SqlServerQuery(Connection connection) {
        con = connection;
    }

}
