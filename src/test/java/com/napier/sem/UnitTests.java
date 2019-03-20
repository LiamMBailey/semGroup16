package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//SOM,Somalia,Africa,Eastern Africa,10097000,3214

class UnitTests {


    SqlStatements sql = new SqlStatements();

    @Test
    void countryReportTestNull() {

        //arrange
        String expected = null;
        List<Country> actual = null;

        //assert

        actual =  sql.countryReport(null);

        //act

        assertEquals(actual, expected);

    }

    @Test
    void countryReportTestReturns(){

        //arrange
        List<String> insert = new ArrayList<>();
        insert.add("code,name,continent,region,1000,capital");
        List<Country> actual;

        //act
        actual = sql.countryReport(insert);

        //assert

       assertTrue(actual != null);
    }

    @Test
    void countryReportTestReturnsObject(){

        //arrange
        List<String> insert = new ArrayList<>();
        insert.add("code,name,continent,region,1000,capital");
        List<Country> expected = new ArrayList<>();
        Country country = new Country("code","name","continent","region",1000,"capital");
        expected.add(country);

        List<Country> actual;

        //act
        actual = sql.countryReport(insert);

        //assert
        assertTrue(actual.get(0).getCountryCapital().equals(expected.get(0).getCountryCapital()));
    }

    @Test
    void cityReportTestNull() {

        //arrange
        String expected = null;
        List<City> actual = null;

        //assert

        actual =  sql.cityReport(null);

        //act

        assertEquals(actual, expected);

    }

    @Test
    void cityReportTestReturns(){

        //arrange
        List<String> insert = new ArrayList<>();
        insert.add("name,country,district,1000");
        List<City> actual;

        //act
        actual = sql.cityReport(insert);

        //assert

        assertTrue(actual != null);
    }

    @Test
    void cityReportTestReturnsObject(){

        //arrange
        List<String> insert = new ArrayList<>();
        insert.add("name,country,district,1000");
        List<City> expected = new ArrayList<>();
        City city = new City("name","country","district", 1000);
        expected.add(city);

        List<City> actual;

        //act
        actual = sql.cityReport(insert);

        //assert
        assertTrue(actual.get(0).getCityCountry().equals(expected.get(0).getCityCountry()));
    }

    @Test
    void capitalCityReportTestNull() {

        //arrange
        String expected = null;
        List<CapitalCity> actual = null;

        //assert

        actual =  sql.capitalCityReport(null);

        //act

        assertEquals(actual, expected);

    }

    @Test
    void capitalCityReportTestReturns(){

        //arrange
        List<String> insert = new ArrayList<>();
        insert.add("name,country,1000");
        List<CapitalCity> actual;

        //act
        actual = sql.capitalCityReport(insert);

        //assert

        assertTrue(actual != null);
    }

    @Test
    void capitalCityReportTestReturnsObject(){

        //arrange
        List<String> insert = new ArrayList<>();
        insert.add("name,country,1000");
        List<CapitalCity> expected = new ArrayList<>();
        CapitalCity capitalCity = new CapitalCity("name","country", 1000);
        expected.add(capitalCity);

        List<CapitalCity> actual;

        //act
        actual = sql.capitalCityReport(insert);

        //assert
        assertTrue(actual.get(0).getCapitalCityName().equals(expected.get(0).getCapitalCityName()));
    }


}