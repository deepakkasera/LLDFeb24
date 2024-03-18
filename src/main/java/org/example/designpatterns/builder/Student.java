package org.example.designpatterns.builder;

public class Student {
    String name;
    int age;
    String univName;
    double psp;
    String batch;
    int gradYear;
    String phoneNumber;

    public Student(Builder builder) {
        //Validations start
        if (builder.getAge() < 20) {
            throw new RuntimeException("Age shouldn't be less than 20");
        }
        if (builder.getGradYear() > 2023) {
            throw new RuntimeException("Grad year shouldn't be more than 2023");
        }
        //Validations end

        this.name = builder.getName();
        this.age = builder.getAge();
        this.gradYear = builder.getGradYear();
        this.psp = builder.getPsp();
        ///
    }
}
