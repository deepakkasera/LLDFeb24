package org.example.producerconsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> store;
    private String name;
    private int maxSize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Producer(Queue<Object> store, String name, int maxSize,
             Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producerSemaphore.acquire(); //producerSemaphore--
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            if (store.size() < maxSize) { // P1, P5, P4, P3
            System.out.println("Producer: " + this.name + " is producing, store size = " + store.size());
            store.add(new Object()); // p1 to p3 => 6 to 3
            consumerSemaphore.release(); // consumerSemaphore++
        }
    }
}
