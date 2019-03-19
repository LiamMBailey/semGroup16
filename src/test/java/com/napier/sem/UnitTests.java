package com.napier.sem;

import com.napier.sem.SqlServerConnection;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UnitTests
{
    static SqlServerConnection sql;
    @BeforeAll
    static void init()
    {
        sql = SqlServerConnection.getInstance();
    }

    @Test
   void sqlStatementTestNull(){

        //arrange
        List<String> actual;

        //assert
       actual = sql.command(null);

       //act
        assertEquals(actual, null);

    }

}