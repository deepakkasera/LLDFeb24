package org.example.functionalInterface;

import org.example.inheritance2.C;

import java.util.*;

public class Client {
    static class Car implements Comparable<Car> {
        String name;
        int price;
        int speed;

        Car(String name, int price, int speed) {
            this.name = name;
            this.price =  price;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "[Name = " + this.name + ", Price = " + this.price + ", Speed = " + this.speed + " ]\n";
        }

        @Override
        public int compareTo(Car car1) {
            return this.speed - car1.speed;
            //return 0;
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 5, 3, 1, 2, 4);
        Collections.sort(numbers);
        //System.out.println(numbers);

        Car car1 = new Car("A", 1000, 200);
        Car car2 = new Car("B", 80, 400);
        Car car3 = new Car("C", 700, 150);
        Car car4 = new Car("D", 400, 100);
        Car car5 = new Car("E", 900, 500);
        Car car6 = new Car("F", 350, 50);


        List<Car> cars = Arrays.asList(car1, car2, car3, car4, car5, car6);

//        Comparator<Car> comparator = new Comparator<Car>() {
//            @Override
//            public int compare(Car c1, Car c2) {
//                return c2.speed - c1.speed;
//            }
//        };

        //Comparator<Car> comparator = (c1, c2) -> {
        // c1.price - c2.price;
        //}
        //Collections.sort(cars, (x, y) -> x.price - y.price);
        Collections.sort(cars);
        System.out.println(cars);
    }
}
