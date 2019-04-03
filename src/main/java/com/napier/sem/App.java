package com.napier.sem;

import com.napier.sem.sqlserver.RequirementsSQL;
import com.napier.sem.sqlserver.SqlServerConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
      App a = new App();
        if (args.length < 1)
        {
            a.run_app("localhost:3306");
        }
        else
        {
            a.run_app(args[0]);
        }
      a.run_app();

    }
    public int run_app(String dbLocation){


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

