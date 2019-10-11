package com.company.Accounts.Factory;

import com.company.Accounts.Account;
import com.company.Accounts.Types.Credit;
import com.company.Accounts.Types.Deposit;
import com.company.Accounts.Types.Giro;

public class Factory implements CreateAccount {
    @Override
    public Account newAccount(int commissionFee, double creditLimit) {
        return new Credit(commissionFee, creditLimit);
    }

    @Override
    public Account newAccount(float depositPercentage) {
        return new Giro(depositPercentage);
    }

    @Override
    public Account newAccount(double deposit) {
        return new Deposit(deposit);
    }

}
