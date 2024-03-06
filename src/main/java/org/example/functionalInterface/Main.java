package org.example.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        //Can we create an object of the Interface ? -> NO

        //Way-1 : Create a class which implements the Interface.
        BiPredicate<String, Integer> biPredicate1 = new BiPredicateImpl();
        //System.out.println(biPredicate1.test("Scaler", 10));

        //Way-2 : Anonymous class
        BiPredicate<String, Integer> biPredicate2 = new BiPredicate<>() {
            @Override
            public boolean test(String str, Integer value) {
                return str.length() > value;
            }
        };
        //System.out.println(biPredicate2.test("Scaler", 10));

        //Way-3 : Lambda (java-8)
        //() -> Input params
        //{} -> Implementation
        BiPredicate<String, Integer> biPredicate3 = (str, value) -> str.length() > value;
        System.out.println(biPredicate3.test("Scaler", 2));

        BinaryOperator<String> binaryOperator = (str1, str2) -> {
            System.out.println("We are in Lambda expression for Binary operator");
            return str1 + " " + str2;
        };
        System.out.println(binaryOperator.apply("Scaler", "Bangalore"));

        TestInterface<String> testInterface = (str) -> System.out.println(str);
        testInterface.fun1("Scaler");
    }
}
