package org.example.functionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateImpl implements BiPredicate<String, Integer> {

    @Override
    public boolean test(String str, Integer value) {
//        if (str.length() > value) {
//            return true;
//        }
//        return false;
        return str.length() > value;
    }
}
