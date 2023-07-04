package org.example.oop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class GenericType<T> {

    private T val;

}


@Setter
class Pair <K, V> {
    private K key;
    private V value;

    void printPair(){
        System.out.println(key + ":" + value);
    }
}

class Test {
    public static void main(String[] args) {
        GenericType<Person> type = new GenericType<Person>();
        type.setVal(new Developer());
        type.setVal(new Tester());

        Pair<Integer, Person> pair = new Pair<Integer, Person>();
        pair.setKey(1234);
        pair.setValue(new Developer());
        pair.printPair();

        List<Pair<Integer, Person>> pairs = new ArrayList<Pair<Integer, Person>>();


    }
}

@Data
class Person {
    private String name;
}

class Developer extends Person {
    void code(){
        System.out.println("write code");
    }
}

class Tester extends Person {
    void test(){
        System.out.println("write test");
    }
}
