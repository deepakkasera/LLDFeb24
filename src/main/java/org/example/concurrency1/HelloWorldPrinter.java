package org.example.concurrency1;

public class HelloWorldPrinter implements Runnable {

    @Override
    public void run() {
        //Write the code that you want to execute from a separate thread.
        //Task Code.
        System.out.println("Hello World : Thread name = " + Thread.currentThread().getName());
    }
}
