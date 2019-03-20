package com.napier.sem;
import java.util.ArrayList;
import java.util.List;

//All the countries in the world organised by largest population to smallest.

public class SqlStatements {

    public List<Country> countryReport(List<String> SqlReturn) {
        List<Country> countries = new ArrayList<>();
        if(SqlReturn == null)
        {
            return null;
        }
        for (String country: SqlReturn) {

           String[] countrySplit =  country.split("::");
           String code = countrySplit[0];
           String name = countrySplit[1];
           String continent = countrySplit[2];
           String region = countrySplit[3];
           int population = Integer.parseInt(countrySplit[4]);
           String capital = countrySplit[5];
           Country tempCountry = new Country(code, name,continent,region,population,capital);

           countries.add(tempCountry);
        }
        return countries;
    }

    public List<City> cityReport(List<String> SqlReturn)
    {
        List<City> cities = new ArrayList<>();
        if(SqlReturn == null)
        {
            return null;
        }
        for (String city: SqlReturn) {

            String[] citySplit =  city.split(",");
            String name = citySplit[0];
            String country = citySplit[1];
            String district = citySplit[2];
            int population = Integer.parseInt(citySplit[3]);
            City tempCity = new City(name,country,district,population);

            cities.add(tempCity);
        }
        return cities;
    }

    public List<CapitalCity> capitalCityReport(List<String> SqlReturn)
    {
        List<CapitalCity> capitalCities = new ArrayList<>();
        if(SqlReturn == null)
        {
            return null;
        }
        for (String capitalCity: SqlReturn) {

            String[] capitalCitySplit =  capitalCity.split(",");
            String name = capitalCitySplit[0];
            String country = capitalCitySplit[1];
            int population = Integer.parseInt(capitalCitySplit[2]);
            CapitalCity tempCapitalCity = new CapitalCity(name,country,population);

            capitalCities.add(tempCapitalCity);
        }
        return capitalCities;
    }
}
