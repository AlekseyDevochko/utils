package collections;

import static org.junit.Assert.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ListTest {
    @Before
    public void start(){
        System.out.println("start");
    }
    @After
    public  void finish(){
        System.out.println("finish");
    }

    @Test
    public void initialTest(){
        List list = new ArrayList();
        list.add("Val1");
        list.add(123);
        list.add(new ArrayList());
        list.add(new Object());


        assertTrue(list.size() == 4);

    }

    @Test
    public void genericTest(){
        List<String> list = new ArrayList<String>();
        list.add("Val1");
        list.add("Val2");
        list.add("Val3");



        assertTrue(list.size() == 3);

    }

    @Test
    public void test1(){
        List<String> list = new ArrayList<String>();
        list.add("Val1");
        list.add("Val2");
        list.add("Val3");

        List<String> newList = new ArrayList<String>(list);
        newList.add("val1");
        newList.add(null);

        newList.add(2, "newVal");

        assertEquals(newList.size(), 6);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void test2(){
        List<String> list = new ArrayList<String>(128);

        List<String> listFixedSize = Arrays.asList("One", "Two", "Three");


        listFixedSize.add("Five");

        assertEquals(listFixedSize.size(), 4);



    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test3(){
        List<String> list = new ArrayList<String>(128);
        list.add("zero");

        List<String> listFixedSize = Arrays.asList("One", "Two", "Three");

        list.addAll(listFixedSize);
        list.add("five");



        assertEquals(list.size(), 5);
        assertTrue(list.contains(new String("zero")));

        list.get(-1);



    }

    @Test
    public void test4(){
        List<Integer> numbers = new ArrayList<Integer>(128);
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5));

        numbers.remove(new Integer(5));

        assertEquals(4, numbers.size());

        assertEquals(numbers.remove(2), Integer.valueOf(3));

        numbers.set(2, new Integer(66));
        numbers.add(-2);
        numbers.add(-500);

        numbers.sort(new NumsComparator());

        assertTrue(numbers.get(0) < 0);

    }

    @Test
    public void sortTest(){
        List<String> strs = new ArrayList<String>(Arrays.asList("b", "C", "a"));
        strs.sort(String.CASE_INSENSITIVE_ORDER);

        assertTrue(strs.get(0).equals("a"));

        strs.sort(Comparator.naturalOrder());

        for (String str:
             strs) {
            System.out.println(str);
        }

        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 2, 7));

        nums.sort(new NumsComparatorReverse());

        assertTrue(nums.get(0) == 7 );



    }

    @Test
    public void customSortTest(){
        List<Car> cars = new ArrayList<Car>(Arrays.asList(
                new Car(123, "Opel Zafira", 3.0, Arrays.asList("misha", "bob", "slavic")),
                new Car(322, "Volkswagen Polo", 4.0, Arrays.asList("alex", "iqor")),
                new Car(411, "Apple 777 Pro XXXS Ultra Plus 5G Dual Sim 1488Tb", 2.0, Arrays.asList("vitalya"))));

        cars.sort(Comparator.naturalOrder());

        assertEquals("Opel Zafira", cars.get(1).getModel());

        cars.sort(new CarOwnersNumberComparator());

        assertEquals(1, cars.get(0).getOwners().size());
        assertEquals(2, cars.get(1).getOwners().size());


        cars.sort(new CarOwnerNamesComparator());

        assertTrue(cars.get(0).getModel().startsWith("Volk"));




    }


}

class NumsComparatorReverse implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return (-1) * o1.compareTo(o2);
    }

}

class NumsComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

}


class CarOwnersNumberComparator implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {


        return Integer.valueOf(o1.getOwners().size()).compareTo(o2.getOwners().size());
    }

}

class CarOwnerNamesComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        int size = Math.min(o1.getOwners().size(), o2.getOwners().size());
        for (int i = 0; i < size; i++) {
            int result = o1.getOwners().get(i).compareTo(o2.getOwners().get(i));
            if (result != 0){
                return result;
            }
        }
        return o1.getOwners().size() - o2.getOwners().size();
    }
}

@AllArgsConstructor
@Data
class Car implements Comparable<Car>{
    private long id;
    private String model;
    private double vEngine;

    private List<String> owners;

    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);
    }


}
