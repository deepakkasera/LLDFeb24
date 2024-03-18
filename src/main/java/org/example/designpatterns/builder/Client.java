package org.example.designpatterns.builder;

public class Client {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.setName("Zahidul");
        builder.setAge(25);
        builder.setBatch("MWF Evening");
        builder.setPsp(90.0);
        builder.setGradYear(2022);
        builder.setPhoneNumber("123456789");

        Student student = new Student(builder);

        System.out.println("DEBUG");
    }
}
