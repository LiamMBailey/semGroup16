package com.napier.sem;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        System.out.println("Initialized");
        SqlConnectionImpl sqlServer =  SqlConnectionImpl.getInstance();

        List<String> serverResponse;
        serverResponse =sqlServer.command("Select name From City");

        for (String s: serverResponse){
            System.out.println(s);
        }
        System.out.println("Finished");
    }


}