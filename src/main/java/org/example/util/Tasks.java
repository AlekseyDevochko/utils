package org.example.util;

import java.util.*;

public class Tasks {

    public static void task1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a > b) {
            System.out.println(a + " > " + b);
        } else if (a < b) {
            System.out.println(a + " < " + b);
        } else {
            System.out.println(a + " = " + b);
        }
    }

    public static void task2() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int preResult = Math.max(a, b);
        System.out.println(Math.max(preResult, c));
    }

    public static void task3(double result) {


        if (result >= 8) {
            System.out.println("Ура, я отличник! =)");
        } else if (6 <= result && result < 8) {
            System.out.println("Не плохо =|");
        } else {
            System.out.println("Бывало и лучше =(");
        }

    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n > 0) {
            n += 1;
        } else if (n < 0) {
            n -= 2;
        } else {
            n = 10;
        }

        System.out.println(n);
    }

    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b && a > c) {
            if (b > c) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + c + " " + b);
            }
        } else if (b > a && b > c) {
            if (a > c) {
                System.out.println(b + " " + a + " " + c);
            } else {
                System.out.println(b + " " + c + " " + a);
            }
        } else {
            if (b > a) {
                System.out.println(c + " " + b + " " + a);
            } else {
                System.out.println(c + " " + a + " " + b);
            }
        }

        if (a < b && a < c) {
            if (b < c) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + c + " " + b);
            }
        } else if (b < a && b < c) {
            if (a < c) {
                System.out.println(b + " " + a + " " + c);
            } else {
                System.out.println(b + " " + c + " " + a);
            }
        } else {
            if (b < a) {
                System.out.println(c + " " + b + " " + a);
            } else {
                System.out.println(c + " " + a + " " + b);
            }
        }
    }

    public static void task6(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b && a > c) {
            if (b > c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        } else if (b > a && b > c) {
            if (a > c) {
                System.out.println(a);
            } else {
                System.out.println(c);
            }
        } else {
            if (b > a) {
                System.out.println(b);
            } else {
                System.out.println(a);
            }
        }
    }

    public static void task7(){
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        System.out.println(firstNumber + " x " + secondNumber + " = ?");

        int result = scanner.nextInt();

        if (result == firstNumber * secondNumber){
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong! Correct answer is " + firstNumber * secondNumber);
        }
    }

    public static void task8() {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = scanner.nextDouble();
        double secondNumber = scanner.nextDouble();
        double thirdNumber = scanner.nextDouble();

        if (thirdNumber > secondNumber && secondNumber > firstNumber){
            System.out.println(firstNumber * 2 + " " + secondNumber * 2 + " " + thirdNumber * 2);
        } else {
            System.out.println(firstNumber * (-1) + " " + secondNumber * (-1) + " " + thirdNumber * (-1));
        }
    }

    public static void task9(){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }


        int number = 0;

        for (int i = 0; i < numbers.length; i++) {
            int check = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]){
                    check++;
                }
            }
            if (check == 1){
                number = i;
            }
        }

        System.out.println(number+1);
    }

    public static void task10(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b && a > c) {
            if (b > c) {
                System.out.println(a + b);
            } else {
                System.out.println(a + c);
            }
        } else if (b > a && b > c) {
            if (a > c) {
                System.out.println(b + a);
            } else {
                System.out.println(b + c);
            }
        } else {
            if (b > a) {
                System.out.println(c + b );
            } else {
                System.out.println(c + a);
            }
        }
    }

    public static void task11(){
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double r = scanner.nextDouble();

        double newR = Math.sqrt(x * x + y * y);

        if (r == newR){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }

    public static void task12(){
        System.out.println("________________________1¶¶¶¶_____________________\n" +
                "_______________________1¶__¶¶¶¶___________________\n" +
                "_______________________¶1___1¶¶¶__________________\n" +
                "_______________________¶1____11¶¶_________________\n" +
                "_______________________¶1_____11¶1________________\n" +
                "___________1111111_____¶1______¶1¶________________\n" +
                "________1¶¶111111¶¶¶¶1_¶1______11¶¶_______________\n" +
                "________¶¶¶111______1¶¶¶1_______¶1¶_______________\n" +
                "_________1¶¶¶¶¶¶¶1_____¶¶_______¶1¶1______________\n" +
                "_____________1¶¶¶¶¶1___1¶_______11¶¶______________\n" +
                "________________¶¶1¶1__1¶_______11¶¶______________\n" +
                "_________________1¶_¶___¶________11¶______________\n" +
                "__________________¶¶1¶__¶________11¶______________\n" +
                "___________________¶_¶1_¶________11¶11111_________\n" +
                "___________________1¶_¶_¶________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1_\n" +
                "____________________¶1¶¶¶1______¶1111111¶11¶___1¶_\n" +
                "___________________1111111¶¶__1¶111_11¶11¶_¶1___¶1\n" +
                "________________1¶1111111¶1¶¶1¶_¶1_11¶___1¶1¶___¶1\n" +
                "_____________11¶¶_1¶1_____1_¶¶_¶1_1¶¶_____¶_____¶_\n" +
                "___________1¶¶¶¶_¶¶¶1_______¶_¶1_1¶¶1_____¶____¶¶_\n" +
                "__________1¶__¶_¶1__¶¶_____111¶_¶11¶______¶___¶¶__\n" +
                "__________¶1___1¶___¶¶______1__11¶¶______1¶__¶¶___\n" +
                "__________¶____¶____¶1_____1¶__¶¶¶1______¶1_¶1____\n" +
                "_________1¶___¶¶___¶¶_____¶¶__¶1¶¶______1¶_¶1_____\n" +
                "_________¶¶__¶¶___¶¶_____¶¶___1¶¶_______¶¶1¶______\n" +
                "_________¶1_¶¶__1¶1____1¶1___¶1¶_________11_______\n" +
                "________¶¶_¶¶__¶¶____1¶¶___1¶1¶___________________\n" +
                "_______1¶¶¶1_¶¶1____¶¶1___11¶¶____________________\n" +
                "________11__¶¶____1¶¶_____¶¶¶_____________________\n" +
                "___________¶1____¶¶1____¶¶1¶______________________\n" +
                "__________¶1___1¶1____1¶1¶¶_______________________\n" +
                "_________¶1___¶¶____111¶¶1________________________\n" +
                "________¶¶__1¶1___1_1¶¶¶__________________________\n" +
                "________¶1_1¶1____¶¶¶¶1___________________________\n" +
                "_______¶¶__1¶__1¶¶¶¶1_____________________________\n" +
                "____1¶¶1____1¶¶¶¶¶1_______________________________\n" +
                "1¶¶¶¶1__1¶¶¶¶11___________________________________\n" +
                "¶¶¶¶_1¶¶1_________________________________________\n" +
                "1¶1¶¶¶____________________________________________");

    }

    public static void task13(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите диапазон:");
        int size = scanner.nextInt();

        int guessNumber = new Random().nextInt(size);

        int number = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Введите число:");
            number = scanner.nextInt();

            if (number == guessNumber){
                System.out.println("Поздравляю вы победили");
                break;
            } else if (number > guessNumber){
                System.out.println("Загаданное число меньше!");
            } else {
                System.out.println("Загаданное число больше!");
            }
        }

        if (guessNumber != number) {
            System.out.println("Вы проиграли(");
        }
    }



    public static void main(String[] args) {
        task13();
    }
}
