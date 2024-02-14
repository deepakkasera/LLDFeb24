package org.example.introtooops;

import java.time.temporal.TemporalAccessor;
import java.util.concurrent.Semaphore;

public class Student {
    public String name;
    protected int age;
    private String email;
    String batchName; //default
    private double psp;

    Student(String name, int age, String email) {
        System.out.println("DEBUG");
        this.name = name;
        this.age = age;
        this.email = email;
        this.batchName = "random batch";
        this.psp = 100.0;
    }

    Student() {

    }

    Student(String name) {
        this.name = name;
    }

//    Student(String b) {
//        this.batchName = batchName;
//    }
    Student(int age) {
        this.age = age;
    }

    Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.email = student.email;
    }

    void attendClass() {
        System.out.println("Student is attending class");
    }

    void bookMockInterview() {
        System.out.println("Booking mock interview.");
    }
}
