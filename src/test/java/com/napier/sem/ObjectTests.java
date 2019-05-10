package com.napier.sem;

import com.napier.sem.blueprints.CapitalCity;
import com.napier.sem.blueprints.City;
import com.napier.sem.blueprints.Country;
import com.napier.sem.blueprints.Population;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


//SOM,Somalia,Africa,Eastern Africa,10097000,3214

class ObjectTests {


    @Test
    void CountryTests(){

        //Arrange
        Country c = new Country();
        String name = null;
        String code = null;
        String region = null;
        String continent = null;
        String capital = null;
        int population = 0;


        //Act
        c.setCountryName("test");
        c.setCountryCode("test");
        c.setCountryCapital("test");
        c.setCountryContinent("test");
        c.setCountryPopulation(0);
        c.setCountryRegion("test");

        name = c.getCountryName();
        code = c.getCountryCode();
        region = c.getCountryCode();
        population = c.getCountryPopulation();
        continent = c.getCountryContinent();
        capital = c.getCountryCapital();

        Country d = new Country(code,name,continent,region,population,capital);

        //Assert
        assertEquals(c.toString(), d.toString());

    }

    @Test
    void CityTests(){
        //Arrange
        City c = new City();
        String country = null;
        String district = null;
        String name = null;
        int population = 0;


        //Arrange
        c.setCityCountry("test");
        c.setCityDistrict("test");
        c.setCityName("test");
        c.setCityPopulation(0);

        country = c.getCityCountry();
        district = c.getCityDistrict();
        name = c.getCityName();
        population = c.getCityPopulation();

        City d = new City(name,country,district,population);

        //assert

        assertEquals(c.toString(), d.toString());
    }

    @Test
    void CapitalCityTest(){
        //Arrange
        String name;
        int population;
        String countryName;
        CapitalCity c = new CapitalCity();

        //Act
        c.setCapitalCityPopulation(0);
        c.setCapitalCityCountry("test");
        c.setCapitalCityName("test");

        population = c.getCapitalCityPopulation();
        countryName = c.getCapitalCityCountry();
        name = c.getCapitalCityName();

        CapitalCity d = new CapitalCity(name,countryName,population);

        //assert
        assertEquals(c.toString(),d.toString());
    }

    @Test
    void PopulationTest(){
        //Arrange
        String name;
        long totalPopulation;
        int PopInCities;
        double PopPercentInCities;
        int PopNotInCities;
        double PopPercentNotInCities;

        //act
        Population c = new Population();
        c.setName("test");
        c.setTotalPopulation(3000);
        c.setPopulationInCities(2000);
        c.setPopulationNotInCities(1000);
        c.setPopPercentageInCities(0);
        c.setPopPercentageNotInCities(0);

        name = c.getName();
        totalPopulation = c.getTotalPopulation();
        PopInCities = c.getPopulationInCities();
        PopPercentInCities = c.getPopPercentageInCities();
        PopNotInCities = c.getPopulationNotInCities();
        PopPercentNotInCities = c.getPopPercentageNotInCities();

        Population d = new Population(name,totalPopulation,PopInCities,PopPercentInCities,PopNotInCities,PopPercentNotInCities);

        //assert
        assertEquals(c.toString(),d.toString());
    }
}