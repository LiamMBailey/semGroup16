package com.napier.sem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int n = 0;
        RequirementsSQL requirements = new RequirementsSQL();
        List<String> requirementsList = new ArrayList<>();
        requirementsList = requirements.reportRequirements();

        for (String s : requirementsList) {
            System.out.println(requirementsList.indexOf(s) + 1 + ") " + s);
        }

        System.out.println("\nSelect Report to be Generated: ");
        index = sc.nextInt() - 1;


    }


}

