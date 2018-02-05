package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Nicolas Crespo
 * @version 2017.3.3
 */

public class FileInput {

    private BufferedReader in = null;
    private String fileName;

    /**
     *
     * @param fileName  name of the file
     */
    public FileInput(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        }
    }

    /**
     *
     * @return  returns the line that is read.
     */
    public String fileRead() {
        String line = "";
        int value;

        try {
            while ((value = in.read()) != -1) {
                value += 10;
                System.out.print((char)value);
                line += Character.toString((char)value);
            }
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }


    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
