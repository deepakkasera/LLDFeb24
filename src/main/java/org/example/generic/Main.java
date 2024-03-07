package org.example.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.DoublePredicate;

public class Main {
    public static void main(String[] args) {
//        Pair p = new Pair();
//        p.first = "Scaler";
//        p.second = 100;
//
//        String city = (String) p.second;
//        System.out.println(city);

        Pair<String, Integer> pair = new Pair<>();
        pair.first = "India";
        pair.second = 140;

        String country = pair.first;

        Pair<Double, Double> pair1 = new Pair<>();


        //RAW TYPE
        HashMap hashMap = new HashMap();
        hashMap.put("Deepak", 80.0);
        hashMap.put(80.0, "Deepak");

        //Java 5 -> Generics were introduced.
        // Java is a Backward Compatible language.

        HashMap<String, Integer> hashMap1 = new HashMap<>();
        //hashMap1.p

        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();

        doSomething(animals);
        doSomething(dogs);

        //List<Animal> animals1 = new ArrayList<Dog>(); -> Not possible
        //List<? extends Animal> animals1 = new ArrayList<Dog>(); -> Possible
    }

    private static void doSomething(List<? extends Animal> animals) {
        System.out.println("Inside dosomething function");
    }

    //? extends Animal -> Animal + any child class of Animal.
    //? super Animal -> Animal + parent class of Animal.
}

