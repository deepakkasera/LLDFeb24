package org.example.addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Count count;
    Lock lock;

    Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            lock.lock(); // acquire
            count.value += i;
            lock.unlock(); // release
        }
    }
}
