package org.example.producerconsumermutex;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private String name;
    private int maxSize;

    Consumer(Queue<Object> store, String name, int maxSize) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                //lock //Only one thread can access the store object at a time.
                if (store.size() > 0) { // C1, C3 // T2
                    System.out.println("Consumer: " + this.name + " is consuming, store size =" + store.size());
                    store.remove();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
