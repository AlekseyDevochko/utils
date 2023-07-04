package org.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

    String text = "john";

    public static void main(String[] args) {
        Tester t = new Tester();

        System.out.println("begin");

        int a = 4;
        int b = 0;

        int arr[] = new int[3];


        try {
//            int val = arr[2];
//            System.out.println(t.text.length());
//            System.out.println(a/2);



        } catch (InputMismatchException e){
            System.err.println("Incorrect Integer." + (e.getMessage() != null? " (" + e.getMessage() + ")." : ""));
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        calc();
        System.out.println("end");
    }


    /**
     * @throws  IllegalArgumentException if operator is wrong
     */
    public static void calc() {
        Scanner scan = new Scanner(System.in);
        System.out.println("input #1 number");
        int a = scan.nextInt();
        System.out.println("input #2 number");
        int b = scan.nextInt();
        System.out.println("input operator (+, -, *, /, %)");
        String oper = scan.next().trim();
        if (oper.equals("+")){
            System.out.println(a + b);
        } else if (oper.equals("-")) {
            System.out.println(a - b);
        } else if (oper.equals("*")) {
            System.out.println(a * b);
        } else if (oper.equals("/")) {
            if (b == 0) throw new IllegalArgumentException("Division by zero.");
            System.out.println(a / (b * 1.0));
        } else if (oper.equals("%")) {
            System.out.println(a % b);
        } else {
            throw new IllegalArgumentException("Incorrect operator has been specified.");
        }


    }
}
