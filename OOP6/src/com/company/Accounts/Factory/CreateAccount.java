package com.company.Accounts.Factory;


import com.company.Accounts.Account;

public interface CreateAccount {
    public Account newAccount(int commissionFee, double creditLimit);

    public Account newAccount(float depositPercentage);

    public Account newAccount(double deposit);
}
