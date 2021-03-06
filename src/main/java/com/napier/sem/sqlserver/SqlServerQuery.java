package com.napier.sem.sqlserver;

import com.napier.sem.blueprints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class SqlServerQuery {
    private final SqlServerConnection sqlServerConnection;
    Connection con = null;

    @Autowired
    public SqlServerQuery(SqlServerConnection sqlServerConnection) {
        String location = "localhost:33065";
        this.sqlServerConnection = sqlServerConnection;
        con = sqlServerConnection.connect(location);
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


    // A method that calls the database and returns the response as a list of strings
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

    // A method that calls the database and returns the response as a list of Country Objects
    public List<Country> CountryQuery(String sql) {
        List<Country> serverResponse = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            //where the result set is not empty
            while (rs.next()) {

                //build a new country object and set values
                Country c = new Country();
                String capital = null;

                c.setCountryCode(rs.getString("Code"));
                c.setCountryName(rs.getString("Name"));
                c.setCountryRegion(rs.getString("Region"));
                c.setCountryContinent(rs.getString("Continent"));
                c.setCountryPopulation(Integer.parseInt(rs.getString("Population")));
                try{
                    //get capital city name from code
                    capital = stringQuery("SELECT name FROM city WHERE ID = " + rs.getString("Capital")).get(0);
                }
                catch (Exception e){
                    capital = "No Data";
                }
                c.setCountryCapital(capital);

                serverResponse.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return serverResponse;

    }

    // A method that calls the database and returns the response as a list of City Objects
    public List<City> cityQuery(String sql) {
        List<City> serverResponse = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            //where the result set is not empty

            while (rs.next()) {

                //build a new city object
                City c = new City();
                c.setCityName(rs.getString("Name"));
                c.setCityDistrict(rs.getString("District"));
                c.setCityPopulation(Integer.parseInt(rs.getString("Population")));
                try {
                    //get country name from code
                    String Country = stringQuery(String.format("SELECT name FROM country where Code = '%s'", rs.getString("CountryCode"))).get(0);
                    c.setCityCountry(Country);
                }catch (Exception e){
                    c.setCityCountry("No Data");
                }

                serverResponse.add(c);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return serverResponse;
    }

    // A method that calls the database and returns the response as a list of Capital City Objects
    public List<CapitalCity> capitalCityQuery(String sql) {
        List<CapitalCity> serverResponse = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //where the result set is not empty
            while (rs.next()) {
                //build capital city object
                CapitalCity c = new CapitalCity();
                c.setCapitalCityName(rs.getString(1));
                try {
                    //get country name from code
                    String Country = stringQuery(String.format("SELECT name FROM country where Code = '%s'", rs.getString("CountryCode"))).get(0);
                    c.setCapitalCityCountry(Country);
                }catch (Exception e){
                    c.setCapitalCityCountry("No Data");
                }
                c.setCapitalCityPopulation(Integer.parseInt(rs.getString(3)));

                serverResponse.add(c);
                System.out.println(serverResponse);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return serverResponse;
    }

    public List<Population> populationQuery(String sql) {
        List<Population> serverResponse = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //where the result set is not empty
            while (rs.next()) {
                //build capital city object
                Population p = new Population();
                long population;
                population = Long.parseLong(rs.getString("totalPopulation"));
                long cityPopulation = Long.parseLong(rs.getString("cityPopulation"));
                long notCityPopulation = Long.parseLong(rs.getString("notCityPopulation"));
                double tempPop = population;
                double tempCityPop = cityPopulation;
                double tempNotCityPop = notCityPopulation;
                p.setName(rs.getString("Name"));
                p.setTotalPopulation(population);
                p.setPopulationInCities(cityPopulation);
                p.setPopulationNotInCities(notCityPopulation);
                p.setPopPercentageInCities((tempCityPop/tempPop)*100.0);
                p.setPopPercentageNotInCities((tempNotCityPop/tempPop)*100.0);
                serverResponse.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error here");
            System.out.println(e);
        }
        return serverResponse;
    }

    public List<AdditionalReport> AdditionalQuery(String sql) {
        List<AdditionalReport> serverResponse = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //where the result set is not empty
            while (rs.next()) {
               AdditionalReport ar = new AdditionalReport();
               try {
                   ar.setPopulation(rs.getString("Population").toString());
               }
               catch (Exception e){
                   System.out.println("Error here");
                   System.out.println(e);
               }
                serverResponse.add(ar);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return serverResponse;
    }
}
