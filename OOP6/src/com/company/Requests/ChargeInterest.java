package com.company.Requests;

import com.company.Accounts.Account;
import com.company.Accounts.Types.Deposit;
import com.company.Accounts.Types.Giro;

public class ChargeInterest extends Requests {

    public ChargeInterest(Account account) {
        super(account);
    }

    @Override
    void executeRequest() {
        if (getAccount().getClass() == Giro.class)
            ((Giro)getAccount()).chargeInterest();
        if (getAccount().getClass() == Deposit.class)
            ((Deposit)getAccount()).chargeInterest();
        System.out.println("ChargeInterest()");
    }
}
