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

}