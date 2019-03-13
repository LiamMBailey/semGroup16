package com.napier.sem;

import java.io.Console;
import java.util.List;

public class App {

    public static void main(String[] args) {


        SqlServerConnection sql = SqlServerConnection.getInstance();
        Console console = System.console();
        String sqlStatement;
        do {
            System.out.print("Please enter the SQL command: ");
            sqlStatement = console.readLine();
            List<String> serverResponse = sql.command(sqlStatement);
            serverResponse.forEach(System.out::println);
        }
        while (!sqlStatement.equals("exit"));
        if(sqlStatement.equals("exit")){
            
        }

    }

}