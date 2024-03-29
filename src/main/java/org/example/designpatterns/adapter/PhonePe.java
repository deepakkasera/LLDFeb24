package org.example.designpatterns.adapter;

public class PhonePe {
    private static BankAPI bankAPI = new ICICIAdapter();

    public static void main(String[] args) {
        bankAPI.sendMoney("1234", "9876", 1000);
    }
}
