package org.example.concurrency1;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World : Thread name = " + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);
        thread.start();

        System.out.println("Hello World : Thread name = " + Thread.currentThread().getName());
    }
}

/*
Task : Print Hello World from a new thread.

1. Create a Task.
    -> Create a Task class.
    -> Make this class implement Runnable interface.
    -> Implement the run() method.
2. Create a Thread.
    -> Create thread object.
3. Assign the task to the thread.
    -> Pass task object inside the constructor of thread class.
4. Start the thread.
    -> thread.start();


 */
