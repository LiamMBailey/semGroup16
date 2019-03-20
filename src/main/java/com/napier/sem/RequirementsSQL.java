package com.napier.sem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequirementsSQL {

    public  List<String> reportRequirements() {

        BufferedReader br = null;
        FileReader fr = null;
        String fileName = "reportRequirements/requirements.txt";
        List<String> requirements = new ArrayList<>();
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                requirements.add(line);
            }

        }
        catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        return requirements;
    }

    public String SqlStatementReport(int index, int n){

         String countryFields = "Code, Name, Continent, Region, Population, Capital";

        String sqlStr = null;
        switch (index){
            case 1:
                sqlStr = "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
                break;

        }

        return sqlStr;
    }


}
