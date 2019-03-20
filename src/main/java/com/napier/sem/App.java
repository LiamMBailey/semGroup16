package com.napier.sem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int n = 0;
        Boolean exit = false;
        RequirementsSQL requirements = new RequirementsSQL();
        List<String> requirementsList;
        requirementsList = requirements.reportRequirements();
        SqlServerConnection sql = new SqlServerConnection();
        SqlStatements sqlStmt = new SqlStatements();

        sql.connect("localhost:33060");
        while(!exit){

            for (String s : requirementsList) {
                System.out.println(requirementsList.indexOf(s) + 1 + ") " + s);
            }
            System.out.print("\nSelect Report to be Generated, (or 0 to exit): ");
            index = sc.nextInt() - 1;
            System.out.print("If applicable, enter the value for N: ");
            n = sc.nextInt();

            if(index > 0 && index <= 25)
            {
               String stmt =  requirements.SqlStatementReport(index,n);
               List<String> returns = sql.command(stmt);
              List<Country> countries =  sqlStmt.countryReport(returns);
                for (Country c: countries) {
                    System.out.println(c.toString());

                }


            }
            if(index == 0){
                exit = true;
            }
        }


    }


}

