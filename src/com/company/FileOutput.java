package com.company;

import java.io.*;


/**
 * @author Nicolas Crespo
 * @version 2017.3.3
 */

public class FileOutput {

    Writer out = null;
    private String fileName;

    /**
     *
     * @param fileName  name of the file
     */
    public FileOutput(String fileName) {
        this.fileName = fileName;
        try {
            out = new BufferedWriter(new FileWriter(fileName));
        }
        catch(FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " "  + e);
        }
        catch(IOException e) {
            System.out.println("IO Exception Error: " + fileName + " " + e);
        }
    }

    /**
     *
     * @param line  data being read for decryption
     */
    public void fileDecryption(String line) {
        char value;
        for (int i = 0; i < line.length(); i++) {
            value = line.charAt(i);
            value -= 10;
            fileWrite(Character.toString(value));
        }
    }

    public void fileWrite(String line) {
        try {
            out.write(line+"\n");
        }
        catch(Exception e) {
            System.out.println("File Write Error: " + fileName + " "  + e);
        }
    }

    public void fileClose() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
