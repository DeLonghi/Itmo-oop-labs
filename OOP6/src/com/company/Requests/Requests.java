package com.company.Requests;

import com.company.Accounts.Account;

abstract public class Requests {
    private Requests nextRequest;
    private Account account;

    public Requests(Account account) {
        this.account = account;
    }

    public Requests setNextRequest(Requests nextRequest) {
        this.nextRequest = nextRequest;
        return nextRequest;
    }

    public void execute() {
        executeRequest();
        if (nextRequest != null)
            nextRequest.execute();
    }

    public Account getAccount() {
        return account;
    }

    abstract void executeRequest();
}
