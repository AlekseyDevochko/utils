package collections;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class MapTest {

    @Test
    public void initTest(){
        Map<String, List<String>> map = new HashMap<>();
        String key = "J2022";
//        int h = (h = key.hashCode()) ^ (h >>> 16);
//        System.out.println(h);
        map.put(key, Arrays.asList("john", "bob"));
        map.put("J2023", Arrays.asList("mike vazovskiy", "ice cream"));
        map.put("J2024", Arrays.asList("Jack", "steeve"));

        assertEquals(map.size(), 3);
        map.put("J2024", Arrays.asList("igor", "dinosaur"));

        List<String> val = map.get("J2024");

        assertEquals(val.get(0), "igor");

        Map<String, List<String>> map2 = new HashMap<>();
        map.put("J2019", Arrays.asList("mike vazovskiy II", "ice cream II"));
        map.put("J2007", Arrays.asList("Jack", "steeve"));

        map.putAll(map2);
        assertEquals(map.size(), 5);
    }

    @Test
    public void collisionTest(){
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person(123, "mike"), 6.8);
        map.put(new Person(321, "bob"), 7.8);

    }
}


class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
