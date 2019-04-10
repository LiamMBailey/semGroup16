package com.napier.sem.sqlserver;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class RequirementsSQL {

    //Class that loads SQL statements from a file and returns them as as list of strings
    public  List<String> reportRequirements() {


        //buffered reader reading the file
        BufferedReader br = null;
        FileReader fr = null;
        String fileName = "reportRequirements/requirements.txt";
        List<String> requirements = new ArrayList<>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                requirements.add(line);
            }

        }
        //handling exceptions
        catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            //closing the stream
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


}
