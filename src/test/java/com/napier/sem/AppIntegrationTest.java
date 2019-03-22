package com.napier.sem;
import com.napier.sem.sqlserver.SqlServerConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest {

   static SqlServerConnection sql;
    @BeforeAll
    static void init()
    {
        sql = new SqlServerConnection();
        sql.connect("localhost:33060");

    }

    @Test
    void getCityTest(){
        //arrange
        List<String> actual;
        String expected = "Edinburgh";

        //act
        actual = sql.command("Select name FROM city where name='Edinburgh'", "city");
        String actualCity = actual.get(1);

        //assert
        assertEquals(actualCity,expected);

    }

    @Test
    void getCountryTest(){
        //arrange
        List<String> actual;
        String expected = "Germany";

        //act
        actual = sql.command("Select name FROM country where name='Germany'","City");
        String actualCity = actual.get(1);

        //assert
        assertEquals(actualCity,expected);

    }


}
