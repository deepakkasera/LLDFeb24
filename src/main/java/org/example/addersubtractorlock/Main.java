package org.example.addersubtractorlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        //TODO -> Read about ReentrantLock.
        Lock lock = new ReentrantLock();

        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        //TODO -> Read about join.
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
