package com.napier.sem;
import com.napier.sem.blueprints.CapitalCity;
import com.napier.sem.blueprints.City;
import com.napier.sem.blueprints.Country;
import com.napier.sem.sqlserver.RequirementsSQL;
import com.napier.sem.sqlserver.SqlServerConnection;
import com.napier.sem.sqlserver.SqlServerQuery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppIntegrationTest {

    static SqlServerConnection sqlServerConnection;
    static SqlServerQuery sqlServerQuery;
    @BeforeAll
    public static void innit(){
         sqlServerConnection = new SqlServerConnection();
         sqlServerQuery = new SqlServerQuery(sqlServerConnection);
    }

    @Test
    public void String_List_Return_Test_Null(){
        //Arrange
        List<String> actual;
        List<String> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.stringQuery(null);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void String_List_Return_Test_Empty(){
        //Arrange
        List<String> actual;
        List<String> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.stringQuery("");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void String_List_Return_Test_Invalid(){
        //Arrange
        List<String> actual;
        List<String> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.stringQuery("From City Select Name");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void String_List_Return_Test_Valid(){
        //Arrange
        List<String> actual;
        List<String> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.stringQuery("Select Name From city where Name = 'London'");
        expected.add("London");

        //Assert
        assertEquals(expected.get(0),actual.get(0));
    }

    @Test
    public void Country_List_Return_Test_Null(){
        //Arrange
        List<Country> actual;
        List<Country> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.CountryQuery(null);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void Country_List_Return_Test_Empty(){
        //Arrange
        List<Country> actual;
        List<Country> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.CountryQuery("");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void Country_List_Return_Test_Invalid(){
        //Arrange
        List<Country> actual;
        List<Country> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.CountryQuery("From Country Select Name");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void Country_List_Return_Test_Valid(){
        //Arrange
        List<Country> actual;
        List<Country> expected = new ArrayList<>();
        Country c = new Country();

        //Act
        actual =  sqlServerQuery.CountryQuery("Select * From country where name = 'United Kingdom'");
        System.out.println(actual.get(0).toString());
        c.setCountryCode("GBR");
        c.setCountryName("United Kingdom");
        c.setCountryContinent("Europe");
        c.setCountryRegion("British Islands");
        c.setCountryPopulation(59623400);
        c.setCountryCapital("London");

        expected.add(c);
        //Assert
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
    }

    @Test
    public void City_List_Return_Test_Null(){
        //Arrange
        List<City> actual;
        List<City> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.cityQuery(null);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void City_List_Return_Test_Empty(){
        //Arrange
        List<City> actual;
        List<City> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.cityQuery("");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void City_List_Return_Test_Invalid(){
        //Arrange
        List<City> actual;
        List<City> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.cityQuery("From City Select Name");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void City_List_Return_Test_Valid(){
        //Arrange
        List<City> actual;
        List<City> expected = new ArrayList<>();
        City c = new City();

        //Act
        actual =  sqlServerQuery.cityQuery("Select * From city where name = 'Edinburgh'");
        System.out.println(actual.get(0).toString());
        c.setCityName("Edinburgh");
        c.setCityCountry("United Kingdom");
        c.setCityDistrict("Scotland");
        c.setCityPopulation(450180);


        expected.add(c);
        //Assert
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
    }

    @Test
    public void CapitalCity_List_Return_Test_Null(){
        //Arrange
        List<CapitalCity> actual;
        List<CapitalCity> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.capitalCityQuery(null);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void CapitalCity_List_Return_Test_Empty(){
        //Arrange
        List<CapitalCity> actual;
        List<CapitalCity> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.capitalCityQuery("");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void CapitalCity_List_Return_Test_Invalid(){
        //Arrange
        List<CapitalCity> actual;
        List<CapitalCity> expected = new ArrayList<>();

        //Act
        actual =  sqlServerQuery.capitalCityQuery("From City Select Name");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void CapitalCity_List_Return_Test_Valid(){
        //Arrange
        List<CapitalCity> actual;
        List<CapitalCity> expected = new ArrayList<>();
        CapitalCity c = new CapitalCity();

        //Act
        actual =  sqlServerQuery.capitalCityQuery("Select * From city where name = 'London'");
        System.out.println(actual.get(0).toString());
        c.setCapitalCityName("London");
        c.setCapitalCityCountry("United Kingdom");
        c.setCapitalCityPopulation(7285000);


        expected.add(c);
        //Assert
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
    }



}
