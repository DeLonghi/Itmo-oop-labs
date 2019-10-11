package com.company.Clients;

import com.company.Accounts.Account;
import com.company.Accounts.Factory.Factory;

import java.util.ArrayList;

public class Client extends Factory {
    private String firstName;
    private String lastName;
    private String address;
    private long passportNum;
    private ArrayList<Account> accounts;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public long getPassportNum() {
        return passportNum;
    }


    private Client(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.passportNum = builder.passportNum;
        this.accounts = new ArrayList<>();

    }

    static public class Builder {
        private String firstName;
        private String lastName;
        private String address;
        private long passportNum;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPassportNum(long passportNum) {
            this.passportNum = passportNum;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public Account newAccount(int commissionFee, double creditLimit) {
        Account credit = super.newAccount(commissionFee, creditLimit);
        if ((this.address == null) || (this.passportNum == 0)) {
            credit.setStatus(Account.UNVERIFIED);
        } else {
            credit.setStatus(Account.VERIFIED);
        }
        return credit;
    }


    @Override
    public Account newAccount(float depositPercentage) {
        Account giro = super.newAccount(depositPercentage);
        if ((this.address == null) || (this.passportNum == 0)) {
            giro.setStatus(Account.UNVERIFIED);
        } else {
            giro.setStatus(Account.VERIFIED);
        }
        giro.setOwner(this);
        return giro;
    }

    @Override
    public Account newAccount(double _deposit) {
        Account deposit = super.newAccount(_deposit);
        if ((this.address == null) || (this.passportNum == 0)) {
            deposit.setStatus(Account.UNVERIFIED);
        } else {
            deposit.setStatus(Account.VERIFIED);
        }
        return deposit;
    }


}
