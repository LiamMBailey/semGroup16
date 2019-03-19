package com.napier.sem;
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

    }

    @Test
    void getCityTest(){
        //arrange
        List<String> actual;
        String expected = "Edinburgh";

        //act
        actual = sql.command("Select name FROM city where name='Edinburgh'");
        String actualCity = actual.get(0);

        //assert
        assertEquals(actualCity,expected);

    }
}
