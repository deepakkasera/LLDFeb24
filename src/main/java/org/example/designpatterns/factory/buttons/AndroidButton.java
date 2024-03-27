package org.example.designpatterns.factory.buttons;

public class AndroidButton implements Button {
    @Override
    public void click() {
        System.out.println("Android button clicking");
    }
}
