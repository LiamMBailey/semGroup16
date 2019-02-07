package com.napier.sem;

import java.sql.Connection;
import java.util.List;

interface SqlConnectionInterface{
    Connection connect();
    List<String> command(String command);
    void CloseConnection();
}
