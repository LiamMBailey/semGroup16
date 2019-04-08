package com.napier.sem;

import com.napier.sem.blueprints.CapitalCity;
import com.napier.sem.blueprints.City;
import com.napier.sem.blueprints.Country;
import com.napier.sem.blueprints.Population;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {

    /** CapitalCity */
    private final String capitalCityName = "testName";
    private final String capitalCityCountry = "testCountry";
    private final int capitalCityPopulation = 100;

    @Test
    void CapitalCity_ShouldBeCreated_Empty(){
        CapitalCity sut = new CapitalCity();

        assertNotNull(sut);
        assertNull(sut.getCapitalCityCountry());
        assertNull(sut.getCapitalCityName());
        assertEquals(0, sut.getCapitalCityPopulation());
    }
    @Test
    void CapitalCity_ShouldBeCreated_WithProperties(){
        CapitalCity sut = new CapitalCity(capitalCityName, capitalCityCountry,capitalCityPopulation);

        assertNotNull(sut);
        assertEquals(capitalCityCountry, sut.getCapitalCityCountry());
        assertEquals(capitalCityName, sut.getCapitalCityName());
        assertEquals(capitalCityPopulation, sut.getCapitalCityPopulation());
    }
    @Test
    void CapitalCity_ShouldBeAbleTo_SetProperties(){
        CapitalCity sut = new CapitalCity();
        sut.setCapitalCityCountry(capitalCityCountry);
        sut.setCapitalCityName(capitalCityName);
        sut.setCapitalCityPopulation(capitalCityPopulation);

        assertEquals(capitalCityCountry, sut.getCapitalCityCountry());
        assertEquals(capitalCityName, sut.getCapitalCityName());
        assertEquals(capitalCityPopulation, sut.getCapitalCityPopulation());
    }
    @Test
    void CapitalCity_ShouldOverride_ToStringMethod(){
        CapitalCity sut = new CapitalCity(capitalCityName, capitalCityCountry,capitalCityPopulation);

        String expectedString = "testName, testCountry, 100";
        assertEquals(expectedString, sut.toString());
    }
    /** City */
    private final String cityName = "testName";
    private final String cityCountry = "testCountry";
    private final String cityDistrict = "testDistrict";
    private final int cityPopulation = 100;

    @Test
    void City_ShouldBeCreated_Empty(){
        City sut = new City();

        assertNotNull(sut);
        assertNull(sut.getCityCountry());
        assertNull(sut.getCityName());
        assertNull(sut.getCityDistrict());
        assertEquals(0, sut.getCityPopulation());
    }
    @Test
    void City_ShouldBeCreated_WithProperties(){
        City sut = new City(cityName, cityCountry, cityDistrict, cityPopulation);

        assertNotNull(sut);
        assertEquals(cityCountry, sut.getCityCountry());
        assertEquals(cityName, sut.getCityName());
        assertEquals(cityDistrict, sut.getCityDistrict());
        assertEquals(cityPopulation, sut.getCityPopulation());
    }
    @Test
    void City_ShouldBeAbleTo_SetProperties(){
        City sut = new City();
        sut.setCityCountry(cityCountry);
        sut.setCityName(cityName);
        sut.setCityPopulation(cityPopulation);
        sut.setCityDistrict(cityDistrict);

        assertEquals(cityCountry, sut.getCityCountry());
        assertEquals(cityName, sut.getCityName());
        assertEquals(cityDistrict, sut.getCityDistrict());
        assertEquals(cityPopulation, sut.getCityPopulation());
    }
    @Test
    void City_ShouldOverride_ToStringMethod(){
        City sut = new City(cityName, cityCountry, cityDistrict, cityPopulation);

        String expectedString = "testName, testCountry, testDistrict, 100";
        assertEquals(expectedString, sut.toString());
    }
    /** Country */
    private final String countryCode = "testCode";
    private final String countryName = "testName";
    private final String countryContinent = "testContinent";
    private final String countryRegion = "testRegion";
    private final int countryPopulation = 100;
    private final String countryCapital = "testCapital";

    @Test
    void Country_ShouldBe_CreatedEmpty(){
        Country sut = new Country();

        assertNotNull(sut);
        assertNull(sut.getCountryCode());
        assertNull(sut.getCountryCapital());
        assertNull(sut.getCountryContinent());
        assertNull(sut.getCountryName());
        assertNull(sut.getCountryRegion());
        assertEquals(0, sut.getCountryPopulation());
    }
    @Test
    void Country_ShouldBeCreated_WithProperties(){
        Country sut = new Country(countryCode, countryName, countryContinent, countryRegion, countryPopulation, countryCapital);

        assertNotNull(sut);
        assertEquals(countryCode, sut.getCountryCode());
        assertEquals(countryName, sut.getCountryName());
        assertEquals(countryContinent, sut.getCountryContinent());
        assertEquals(countryRegion, sut.getCountryRegion());
        assertEquals(countryPopulation, sut.getCountryPopulation());
        assertEquals(countryCapital, sut.getCountryCapital());
    }
    @Test
    void Country_ShouldBeAble_ToSetProperties(){
        Country sut = new Country();

        sut.setCountryCode(countryCode);
        sut.setCountryCapital(countryCapital);
        sut.setCountryContinent(countryContinent);
        sut.setCountryName(countryName);
        sut.setCountryPopulation(countryPopulation);
        sut.setCountryRegion(countryRegion);

        assertEquals(countryCode, sut.getCountryCode());
        assertEquals(countryName, sut.getCountryName());
        assertEquals(countryContinent, sut.getCountryContinent());
        assertEquals(countryRegion, sut.getCountryRegion());
        assertEquals(countryPopulation, sut.getCountryPopulation());
        assertEquals(countryCapital, sut.getCountryCapital());
    }
    @Test
    void Country_ShouldOverride_ToStringMethod(){
        Country sut = new Country(countryCode, countryName, countryContinent, countryRegion, countryPopulation, countryCapital);

        String expectedString = "testCode , testName , testContinent , testRegion , 100 , testCapital";

        assertEquals(expectedString, sut.toString());
    }
    /** Population */

    private final String populationName = "testName";
    private final int  TotalPopulation = 100;
    private final int PopulationInCities = 60;
    private final double PopPercentageInCities = 0.6;
    private final int PopulationNotInCities = 40;
    private final double PopPercentageNotInCities = 0.4;

    @Test
    void Population_ShouldBeCreated_Empty(){
        Population sut = new Population();

        assertNotNull(sut);
        assertNull(sut.getName());
        assertEquals(1, sut.getTotalPopulation());
        assertEquals(0, sut.getPopulationInCities());
        assertEquals(0, sut.getPopPercentageInCities());
        assertEquals(0, sut.getPopulationNotInCities());
        assertEquals(0, sut.getPopPercentageNotInCities());
    }
    @Test
    void Population_ShouldBeCreated_WithProperties(){
        Population sut = new Population(populationName, TotalPopulation, PopulationInCities, PopPercentageInCities, PopulationNotInCities, PopPercentageNotInCities);

        assertNotNull(sut);
        assertEquals(populationName, sut.getName());
        assertEquals(TotalPopulation, sut.getTotalPopulation());
        assertEquals(PopulationInCities, sut.getPopulationInCities());
        assertEquals(PopPercentageInCities, sut.getPopPercentageInCities());
        assertEquals(PopulationNotInCities, sut.getPopulationNotInCities());
        assertEquals(PopPercentageNotInCities, sut.getPopPercentageNotInCities());
    }
    @Test
    void Population_ShouldBeAble_ToSetProperties() {
        Population sut = new Population();

        sut.setName(populationName);
        sut.setTotalPopulation(TotalPopulation);
        sut.setPopulationInCities(PopulationInCities);
        sut.setPopulationNotInCities(PopulationNotInCities);
        sut.setPopPercentageInCities(PopPercentageInCities);
        sut.setPopPercentageNotInCities(PopPercentageNotInCities);

        assertEquals(populationName, sut.getName());
        assertEquals(TotalPopulation, sut.getTotalPopulation());
        assertEquals(PopulationInCities, sut.getPopulationInCities());
        assertEquals(PopPercentageInCities, sut.getPopPercentageInCities());
        assertEquals(PopulationNotInCities, sut.getPopulationNotInCities());
        assertEquals(PopPercentageNotInCities, sut.getPopPercentageNotInCities());
    }
    @Test
    void Population_ShouldOverride_ToStringMethod(){
        Population sut = new Population(populationName, TotalPopulation, PopulationInCities, PopPercentageInCities, PopulationNotInCities, PopPercentageNotInCities);

        String expectedString = "testName, 100, 60, 0.6, 40, 0.4";

        assertEquals(expectedString, sut.toString());
    }
}