package org.example.util;

public class StaticMethodsTester {

    public static void method1() {
        System.out.println("start method1");
        System.out.println("end method1");
    }

    public static void main(String[] args) {
//        System.out.println("start main");
//        method1(); // method invocation
//        method2();
//        System.out.println("end main");

        int[] arr = ArraysUtil.getRandomArray(MathUtils.inputInt(""));
        ArraysUtil.printArray(arr, true);
    }

    public static void method2() {
        System.out.println("start method2");
        method3();
        System.out.println("end method2");
    }

    public static void method3() {
        System.out.println("start method3");
        System.out.println("end method3");
    }


}
