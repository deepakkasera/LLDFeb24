package org.example.designpatterns.builder;

public class Client {
    public static void main(String[] args) {
        //Builder builder = new Builder();
//        Builder builder = Student.getBuilder();
//        builder.setName("Zahidul");
//        builder.setAge(25);
//        builder.setBatch("MWF Evening");
//        builder.setGradYear(2022);
//        builder.setPhoneNumber("123456789");

        //Student student = new Student(builder);

//        Student student = builder.build();

        //Student student1 = new Student(null);

        Student student = Student.getBuilder()
                        .setName("Zahidul")
                        .setAge(25)
                        .setGradYear(2024)
                        .setPhoneNumber("1234")
                        .build();

        System.out.println("DEBUG");
    }
}
