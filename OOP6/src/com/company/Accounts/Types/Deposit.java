package com.company.Accounts.Types;

import com.company.Accounts.Account;

public class Deposit extends Account {
    private int daysBeforeTermExpiration;
    private float depositPercentage;

    public Deposit(double deposit) {
        this.daysBeforeTermExpiration = 365;
        setMoney(deposit);
        this.depositPercentage = (float) (getMoney() * 0.0000075 / 100);
    }

    @Override
    public boolean withdraw(double draw) {
        if (daysBeforeTermExpiration > 0 || getMoney() - draw < 0)
            return false;
        setMoney(getMoney() - draw);
        return true;

    }

    @Override
    public boolean deposit(double deposit) {
        if (deposit < 0)
            return false;
        setMoney(getMoney() + deposit);
        return true;
    }

    @Override
    public boolean transfer(Account account, double transfer) {
        return false;
    }

    public void chargeInterest() {
        if (daysBeforeTermExpiration >= 0)
            setMoney( getMoney() * (1 + depositPercentage));
        System.out.println("1+" + depositPercentage);
    }

}
