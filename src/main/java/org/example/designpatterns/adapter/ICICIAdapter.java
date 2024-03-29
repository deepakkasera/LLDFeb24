package org.example.designpatterns.adapter;

import org.example.designpatterns.adapter.thirdParty.icicibank.ICICIBank;

public class ICICIAdapter implements BankAPI {
    private ICICIBank iciciBank = new ICICIBank();

    @Override
    public void sendMoney(String from, String to, int amount) {
        iciciBank.makePayment(to, from, amount);
    }

    @Override
    public void registerAccount(String accountNumber) {

    }

    @Override
    public long getBalance(String accountNumber) {
        return 0;
    }
}
