package org.example.exceptions;

import javax.swing.*;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2); // TRUE
        System.out.println(s1 == s3); // FALSE
        System.out.println(s2 == s3); // FALSE

        System.out.println(s1.equals(s2)); // TRUE
        System.out.println(s1.equals(s3)); // TRUE
        System.out.println(s2.equals(s3)); // TRUE

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
    }
}
