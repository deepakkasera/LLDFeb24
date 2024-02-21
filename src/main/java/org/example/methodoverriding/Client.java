package org.example.methodoverriding;

import java.io.Serializable;

public class Client {
    public static void main(String[] args) {
        User user = new User();
        user.login("Scaler", "Bangalore");

        user = new Mentor();
        user.login("Scaler", "Bangalore");

        Mentor mentor = new Mentor();
        mentor.login("Scaler", "Bangalore");


        //mentor = new User();
        //mentor.login("Scaler", "Bangalore");
    }
}
