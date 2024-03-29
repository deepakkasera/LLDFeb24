package org.example.designpatterns.adapter;

import org.example.designpatterns.adapter.thirdParty.yesbank.YesBank;

public class YesBankAdapter implements BankAPI {
    private YesBank yesBank = new YesBank();

    @Override
    public void sendMoney(String from, String to, int amount) {
        yesBank.transferMoney(amount, from, to);
    }

    @Override
    public void registerAccount(String accountNumber) {

    }

    @Override
    public long getBalance(String accountNumber) {
        return 0;
    }
}
