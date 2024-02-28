package org.example.producerconsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private String name;
    private int maxSize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Consumer(Queue<Object> store, String name, int maxSize,
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
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer: " + this.name + " is consuming, store size =" + store.size());
            store.remove();
            producerSemaphore.release();
        }
    }
}
