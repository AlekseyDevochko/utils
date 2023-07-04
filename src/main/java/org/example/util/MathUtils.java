package org.example.util;

import java.util.Scanner;

public class MathUtils {


    public static int printSum(int a, int b) {
        return a + b;
    }

    public static int printSub(int a, int b) {
        return a - b;
    }

    public static int printMul(int a, int b) {
        return a * b;
    }

    public static int printDiv(int a, int b) {
        return a / b;
    }

    /**
     * Same as System.out.println() but in MathUtils
     * @param a int value to print
     */
    public static void print(int a){
        System.out.println(a);
    }

    /**
     * Same as System.out.println() but in MathUtils
     * @param a int value to print
     */
    public static void printNotLn(int a){
        System.out.println(a);
    }

    /**
     * Generate random int type value
     * @return a pseudorandom int value from 0 to 100
     */
    public static int getRandom(){
        return (int) (Math.random() * 100);
    }

    /**
     * Generate random int type value
     * @param border exclusive
     * @return  a pseudorandom int value from 0 to border
     */
    public static int getRandom(int border){
        return (int) (Math.random() * (border));
    }

    /**
     * Generate random int type value
     * @param downBorder inclusive
     * @param upperBorder exclusive
     * @return a pseudorandom int value from downBorder to upperBorder
     */
    public static int getRandom(int downBorder, int upperBorder){
        if (downBorder > upperBorder){
            return -1;
        }
        return downBorder + (int) (Math.random() * (upperBorder - downBorder + 1));
    }

    // client
    public static void main(String[] args) {
//        System.out.println(printSum(new Random().nextInt(100), new Random().nextInt(100)));
//        System.out.println(printSub(new Random().nextInt(100), new Random().nextInt(100)));
//        System.out.println(printDiv(new Random().nextInt(100), new Random().nextInt(100)));
//        System.out.println(printMul(new Random().nextInt(100), new Random().nextInt(100)));
//
//        System.out.println();
//
//        System.out.println(printSum((int) (Math.random() * 100), (int) (Math.random() * 100)));
//        System.out.println(printSub((int) (Math.random() * 100), (int) (Math.random() * 100)));
//        System.out.println(printDiv((int) (Math.random() * 100), (int) (Math.random() * 100)));
//        System.out.println(printMul((int) (Math.random() * 100), (int) (Math.random() * 100)));



        print(getRandom(9,10));




    }

    /**
     * Get value from keyboard
     * @param string line of text
     * @return int type value
     */
    public static int inputInt(String string){
        System.out.print(string);
        return new Scanner(System.in).nextInt();
    }

    /**
     * Get value from keyboard
     * @param string line of text
     * @return double type value
     */
    public static double inputDouble(String string){
        System.out.print(string);
        return new Scanner(System.in).nextDouble();
    }
}
