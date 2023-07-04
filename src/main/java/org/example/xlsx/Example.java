package org.example.xlsx;


import java.util.Date;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<Car> cars = XlsxCarUtil.loadCars("D:\\st-gr-J2022\\cars_table.xlsx");
        cars.add(new Car(77, "Range Rover", 777.12, new Date()));
        cars.add(new Car(777, "ferrari", 7777.12, new Date()));

        XlsxCarUtil.writeCars("D:\\st-gr-J2022\\cars_table" + new Date().getTime() + ".xlsx", cars);


    }
}
