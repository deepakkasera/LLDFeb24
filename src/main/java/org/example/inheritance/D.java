package org.example.inheritance;

public class D extends C {
    String address;

    D() {
        super( 10, "Scaler"); //Should be the first line inside the constructor.
        System.out.println("Constructor of D");
    }

//    D(String str) {
//        address = str;
//        System.out.println("Constructor of D with 1 param");
//    }

    //super refers to the parent (immediate parent).
}
