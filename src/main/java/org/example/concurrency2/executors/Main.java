package org.example.concurrency2.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        NumberPrinter numberPrinter = null;
//        Thread t = null;
//        for (int i = 1; i <= 100; i++) {
//            NumberPrinter numberPrinter = new NumberPrinter(i);
//            Thread t = new Thread(numberPrinter);
//            t.start();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //Executor executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            if (i == 50) {
                System.out.println("Hello");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);
        }
        executorService.shutdown();
    }
}
