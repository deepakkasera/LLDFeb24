package org.example.addersubtractorsynchronized;

public class Subtractor implements Runnable {
    Count count;

    Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            synchronized (count) {
                count.value -= i;
            }
        }
    }
}
