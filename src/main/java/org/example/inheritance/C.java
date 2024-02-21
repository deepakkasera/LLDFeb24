package org.example.inheritance;

public class C extends B {
    String phone;

    C() {
        System.out.println("Constructor of C");
    }

    C(String str) {
        System.out.println("Constructor of C with 1 param");
    }

    C(String str1, String str2) {
        System.out.println("Constructor of C with 2 param");
    }

    C(String str, int marks) {
        System.out.println("Constructor of C with 2 param, with String and int");
    }

    C(int marks, String str) {
        System.out.println("Constructor of C with 2 param, with int and String");
    }
}
