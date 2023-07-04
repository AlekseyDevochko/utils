package org.example.exceptions.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTester {
    public static void main(String[] args) {
        String path = "D:\\readme.txt";
        try {

            InputStream input = new FileInputStream(path);

            int b;
            while ((b = input.read()) != -1){
                System.out.print((char) b);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found from : " + path);;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Generic I/O Exception : " + e.getMessage());;

        }

    }
}
