package com.company.Accounts;

import com.company.Clients.Client;

public abstract class Account {
    public static final String VERIFIED = "VERIFIED";
    public static final String UNVERIFIED = "UNVERIFIED";

    private double money;



    private Client owner;
    private String status;

    public abstract boolean withdraw(double draw);

    public abstract boolean deposit(double deposit);

    public abstract boolean transfer(Account account, double transfer);

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
