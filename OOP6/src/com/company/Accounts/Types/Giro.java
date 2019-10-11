package com.company.Accounts.Types;

import com.company.Accounts.Account;

public class Giro extends Account {
    private double money;
    private float depositPercentage;

    public Giro(float depositPercentage) {
        this.depositPercentage = depositPercentage;

    }

    @Override
    public boolean withdraw(double draw) {
        if (money - draw >= 0) {
            money -= draw;
            return true;
        } else return false;
    }

    @Override
    public boolean deposit(double deposit) {
        if (deposit < 0)
            return false;
        money += deposit;
        System.out.println("Gira");
        return true;
    }


    @Override
    public boolean transfer(Account account, double transfer) {
        if (account.getOwner() == this.getOwner() && money - transfer >= 0) {
            this.withdraw(transfer);
            account.deposit(transfer);
            return true;
        }
        return false;
    }

    public void chargeInterest() {
        money *= (1 + depositPercentage);
    }
}

