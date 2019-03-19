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

           String[] countrySplit =  country.split(",");
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
}
