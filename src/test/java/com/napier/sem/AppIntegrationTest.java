package com.napier.sem;
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



}
