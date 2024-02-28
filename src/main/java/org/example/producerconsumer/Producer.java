package org.example.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> store;
    private String name;
    private int maxSize;

    Producer(Queue<Object> store, String name, int maxSize) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            if (store.size() < maxSize) { // P1, P5, P4, P3
                System.out.println("Producer: " + this.name + " is producing, store size = " + store.size());
                store.add(new Object());
            }
        }
    }
}
