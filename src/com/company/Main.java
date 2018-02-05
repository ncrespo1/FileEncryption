package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Nicolas Crespo
 * @version 2017.3.3
 */

public class Main {

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String fileName;
        String ans;
        String stuff = "";

        System.out.print("Enter the file name: ");
        fileName = keyboard.nextLine();


        PrintWriter outputFile = new PrintWriter(fileName);

        do{
            System.out.println("Do you want to enter some (T)ext or do you want to enter a (N)umber or (E)xit?: ");
            ans = keyboard.nextLine();
            if (ans.toUpperCase().charAt(0) == 'T') {
                System.out.print("Enter some text: ");
                stuff = keyboard.nextLine();
                outputFile.println(stuff);
            } else if (ans.toUpperCase().charAt(0) == 'N') {
                int num;
                System.out.println("Enter a whole number greater than zero: ");
                num = keyboard.nextInt();
                keyboard.nextLine();
                while (num < 0) {
                    System.out.println("Invalid. I said greater than zero: ");
                    num = keyboard.nextInt();
                    keyboard.nextLine();
                }
                outputFile.println(num);
            }
        } while (ans.toUpperCase().charAt(0) != 'E');
        outputFile.close();

        /**
         * Encrypts data from file
         */
        FileInput in = new FileInput(fileName);
        String data = in.fileRead();

        /**
         * Writes encrypted data to file
         */
        FileOutput encrypt = new FileOutput("encrypt.txt");
        encrypt.fileWrite(data);
        encrypt.fileClose();

        /**
         * Decrypts data and writes to file.
         */
        FileOutput decrypt = new FileOutput("decrypt.txt");
        decrypt.fileDecryption(data);
        decrypt.fileClose();

        System.out.println("Data has been stored and altered.");
    }
}
