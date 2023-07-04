package org.example;

import java.util.HashMap;

public class StringTasks {

    // 1.	На вход подается текст, все предложения, которого начинаются с маленькой буквы. Вывести исправленный текст на консоль.

    public static void task1(String text){
        System.out.print(String.valueOf(text.charAt(0)).toUpperCase());
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?' ){

                if (i + 2 < text.length()){
                    System.out.print(text.charAt(i));
                    System.out.print(text.charAt(i + 1));
                    System.out.print(String.valueOf(text.charAt(i + 2)).toUpperCase());
                    i+=2;
                } else {
                    System.out.print(text.charAt(i));
                    return;
                }
            } else {
                System.out.print(text.charAt(i));
            }
        }
    }

//2.	На вход подается 1 строка. Необходимо вывести букву, которая встречается в строке дважды.

    public static void task2(String text){
//        for (int i = 0; i < text.length(); i++) {
//            char value = text.charAt(i);
//            for (int j = i + 1; j < text.length(); j++) {
//                if (value == text.charAt(j)){
//                    System.out.println(value);
//                    return;
//                }
//            }
//        }

        for (int i = 0; i < text.length(); i++) {
            char value = text.charAt(i);
            if (text.indexOf(value, i+1) != -1){
                System.out.println(value);
                return;
            }
        }
    }

//    3.	На вход подается 1 строка. Необходимо вывести букву, которая встречается в строке больше всего.

    public static void task3(String text){
        HashMap<String, Integer> mapWithCounts = new HashMap<String, Integer>();
        for (int i = 0; i < text.length(); i++) {
            if (mapWithCounts.containsKey(String.valueOf(text.charAt(i)))){
                Integer value = mapWithCounts.get(String.valueOf(text.charAt(i)));
                mapWithCounts.remove(String.valueOf(text.charAt(i)));
                mapWithCounts.put(String.valueOf(text.charAt(i)), value + 1);

            } else {
                mapWithCounts.put(String.valueOf(text.charAt(i)), 1);
            }
        }

        Integer max = Integer.MIN_VALUE;

        String maxChar = "";

        for (String value :
                mapWithCounts.keySet()) {
            if (mapWithCounts.get(value) > max){
                max = mapWithCounts.get(value);
                maxChar = value;
            }
        }



        System.out.println(maxChar);
    }

//    4.	На вход подается 1 строка. Необходимо вывести эту же строку символы которой будут менять свой регистр.

    public static void task4(String text){
        for (int i = 0; i < text.length(); i++) {
            if (String.valueOf(text.charAt(i)).toUpperCase().equals(String.valueOf(text.charAt(i)))){
                System.out.print(String.valueOf(text.charAt(i)).toLowerCase());
            } else {
                System.out.print(String.valueOf(text.charAt(i)).toUpperCase());
            }
        }
    }

//    5.	При вводе пользователь выделяет строки используя пробел. Необходимо вывести каждую из этих строк.

    public static void task5(String text){
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' '){
                System.out.print(text.charAt(i));
            } else {
                System.out.println();
            }
        }
    }

    public static void taskSpecial1(String text){
        String[] words = text.split(" ");
        System.out.println(words.length);
    }

    public static void main(String[] args) {
        //task1("hi! my name is aleksey. im 20 years old. how are u?");
        //task2("hello, world!");
        //task3("abchffffffffaaaanchfffftddaa");
        //task4("bLa-BLa-blA");
        //task5("bf vbghf ddddf rerer");

        taskSpecial1("v b c v 5");

        String str = "abc";


    }
}
