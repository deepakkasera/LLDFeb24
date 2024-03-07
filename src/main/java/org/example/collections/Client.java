package org.example.collections;

import com.sun.source.tree.Tree;
import org.example.streams.Main;

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
        public int compareTo(Car car) {
            if (!this.name.equals(car.name)) {
                //compare on the basis of name;
                return this.name.compareTo(car.name);
            } else {
                //compare on the basis of price
                return this.price - car.price;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        List<Integer> ll = new LinkedList<>();
        List<Integer> v = new Vector<>();
        List<Integer> st = new Stack<>();

        Set<String> hs = new HashSet<>();
        Set<String> lhs = new LinkedHashSet<>();
        Set<String> ts = new TreeSet<>();

        hs.add("India");
        hs.add("US");
        hs.add("China");
        hs.add("SriLanka");
        hs.add("Australia");

        lhs.add("India");
        lhs.add("US");
        lhs.add("China");
        lhs.add("Australia");
        lhs.add("SriLanka");

        ts.add("India");
        ts.add("US");
        ts.add("China");
        ts.add("Australia");
        ts.add("SriLanka");

        System.out.println(hs);
        System.out.println(lhs); // Linked HashSet maintains the order of insertion.
        System.out.println(ts);

        Car car1 = new Car("A", 1200, 200);
        Car car2 = new Car("A", 80, 400);
        Car car3 = new Car("A", 700, 150);
        Car car4 = new Car("A", 400, 100);
        Car car5 = new Car("A", 1900, 500);
        Car car6 = new Car("A", 350, 50);

        Set<Car> cars = new TreeSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        List<Integer> numbers = new ArrayList<>();



        System.out.println(cars);

    }
}
