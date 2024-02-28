package org.example.addersubtractorsynchronized;

import org.example.introtooops.Student;

public class Adder implements Runnable {
    Count count;

    Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            synchronized (count) {
                count.value += i;
            }
        }
    }
}
