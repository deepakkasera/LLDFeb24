package org.example.designpatterns.factory.buttons;

public class IOSButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicking IOS Button");
    }
}
