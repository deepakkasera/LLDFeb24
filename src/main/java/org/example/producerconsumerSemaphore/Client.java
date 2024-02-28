package org.example.producerconsumerSemaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ArrayDeque<>();
        int maxSize = 5;
        Semaphore producerSemaphore = new Semaphore(maxSize);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer p1 = new Producer(store, "P1", maxSize, producerSemaphore, consumerSemaphore);
        Producer p2 = new Producer(store, "P2", maxSize, producerSemaphore, consumerSemaphore);
        Producer p3 = new Producer(store, "P3", maxSize, producerSemaphore, consumerSemaphore);

        Consumer c1 = new Consumer(store, "C1", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer(store, "C2", maxSize, producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer(store, "C3", maxSize, producerSemaphore, consumerSemaphore);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread t4 = new Thread(c1);
        t4.start();
        Thread t5 = new Thread(c2);
        t5.start();
        Thread t6 = new Thread(c3);
        t6.start();

    }
}
