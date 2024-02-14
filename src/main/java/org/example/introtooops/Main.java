package org.example.introtooops;

public class Main {
    public static void main(String[] args) {
        //int x = 10;
        //Student student = new Student();

        Student student = new Student("Nikhil", 25, "nikhil@gmail.com");
//        Student student1 = new Student("Harshita");
//        Student student2 = new Student(25);
//
//
//        Student student3 = new Student(student);

        System.out.println(student.name);
        System.out.println("Line-1 " + student); // 700
        doSomething(student);
        System.out.println("Line-2 " + student); // //700
        System.out.println("Line-3 " + student.name);
        System.out.println("DEBUG");

//        student1.name = "Deepak";
//        student1.age = 27;
//        student1.batchName = "Dec23 Evening batch";
        //student1.email = "deepak.kasera@scaler.com";

    }

    public static void doSomething(Student student) { //700
        System.out.println("DoSomething-1" + student); // 700
        student = new Student(); // 900
        student.name="Jegan";
        System.out.println("DoSomething-2" + student); // 900
        System.out.println("DoSomething-3" + student.name);
    }
}
