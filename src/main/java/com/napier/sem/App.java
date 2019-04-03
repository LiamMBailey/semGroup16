package com.napier.sem;


import com.napier.sem.sqlserver.RequirementsSQL;
import com.napier.sem.sqlserver.SqlServerConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        Console c =System.console();

        if (args.length < 1)
        {
            System.out.println("localhost.");
          // run_app("localhost:3306");
        }
        else
        {
            System.out.println(args[0]);
            //run_app(args[0]);
        }

        SpringApplication.run(App.class, args);


    }

    public static int run_app(String dbLocation){


        try{
            Scanner sc = new Scanner(System.in);
            int index = 0;
            int n = 0;
            boolean exit = false;
            RequirementsSQL requirements = new RequirementsSQL();
            List<String> requirementsList;
            requirementsList = requirements.reportRequirements();
            SqlServerConnection sql = new SqlServerConnection();
            Connection con = sql.connect(dbLocation);

            while (!exit) {

                for (String s : requirementsList) {
                    System.out.println(requirementsList.indexOf(s) + 1 + ") " + s);
                }
                System.out.print("\nSelect Report to be Generated, (or 0 to exit): ");
                index = sc.nextInt();
                System.out.print("If applicable, enter the value for N: ");
                n = sc.nextInt();

            }

        }
        catch (Exception e){
            return -1;
        }
        return 0;
    }


}


