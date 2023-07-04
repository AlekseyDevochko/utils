package org.example.test;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class TestClass {


    private int a;

    private int b;

}

class TestTestClass{
    public static void main(String[] args) {

        TestClass test = new TestClass(12,14);
        System.out.println(test.getA());
    }



}
