package org.example.concurrency2.printnumber1to100;

import org.example.concurrency1.HelloWorldPrinter;

public class Main {
    public static void main(String[] args) {
//        NumberPrinter numberPrinter = null;
//        Thread t = null;
        for (int i = 1; i <= 100; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t = new Thread(numberPrinter);
            t.start();
        }
    }
}
