package org.example.methodoverriding;

import java.io.Serializable;

public class Mentor extends User  {

//    String login(String email, String password) {
//        //method signature -> login(string, string)
//        System.out.println("Mentor is logging in");
//        return null;
//    }

    void login(String email, String password) {
        System.out.println("Mentor is logging in");
    }

}
