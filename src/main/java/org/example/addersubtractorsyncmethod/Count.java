package org.example.addersubtractorsyncmethod;

public class Count {
    private int value = 0;

    public synchronized void addValue(int i) {
        value += i;
    }

    public int getValue() {
        return value;
    }
}
