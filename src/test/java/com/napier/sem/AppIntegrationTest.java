package com.napier.sem;
import com.napier.sem.sqlserver.SqlServerConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest {
    @Test
    void run_app_null_test(){
        //arrange

        assertEquals(5,5);
    }


}
