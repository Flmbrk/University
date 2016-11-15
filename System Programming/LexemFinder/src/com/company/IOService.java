package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by flmbrk on 07.11.2016.
 */
public class IOService {
    /**
     * Read text from file, print to console.
     */
    private File inputFile;
    private File outputFile;
    private String programText;
    public IOService(String path){
        inputFile = new File(path);
    }

    public void readFromFile() throws FileNotFoundException, IOException {
        BufferedReader reader = null;
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            reader = new BufferedReader(new FileReader(inputFile));
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            this.programText = sb.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void printToConsole(){

    }


}
