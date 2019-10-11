package com.company.Requests;

import com.company.Accounts.Account;
import com.company.Accounts.Factory.CreateAccount;
import com.company.Accounts.Types.Credit;

public class TakeFee extends Requests {

    public TakeFee(Account account) {
        super(account);
    }

    @Override
    void executeRequest() {
        if (getAccount().getClass() == Credit.class)
            getAccount().withdraw(((Credit) getAccount()).getCommissionFee());
    }
}
