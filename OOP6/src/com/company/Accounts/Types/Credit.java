package com.company.Accounts.Types;

import com.company.Accounts.Account;

public class Credit extends Account {
    private double creditLimit;
    private double commissionFee;

    public double getCommissionFee() {
        return commissionFee;
    }

    public Credit(double commissionFee, double creditLimit) {
        this.commissionFee = commissionFee;
        this.creditLimit = creditLimit;
    }


    @Override
    public boolean withdraw(double draw) {
        if (getMoney() - draw <= creditLimit)
            return false;
        setMoney(getMoney() - draw);
        return true;
    }

    @Override
    public boolean deposit(double deposit) {
        setMoney(getMoney() + deposit);
        return false;
    }

    @Override
    public boolean transfer(Account account, double transfer) {
        return false;
    }
}
