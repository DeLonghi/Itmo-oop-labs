package com.company;

import com.company.Accounts.Account;
import com.company.Clients.Client;
import com.company.Requests.ChargeInterest;
import com.company.Requests.Requests;
import com.company.Requests.TakeFee;

public class Main {

    public static void main(String[] args) {
        Client Ilya = new Client.Builder("Ilya", "Vinnikov").setPassportNum(123456).setAddress("Address").build();
        System.out.println(Ilya.getFirstName());
        System.out.println(Ilya.getLastName());
        System.out.println(Ilya.getAddress());
        System.out.println(Ilya.getPassportNum());
        Account account = Ilya.newAccount((double) 1000000);
//        account.deposit(11);
        System.out.println(account.getStatus());
        Requests requests = new ChargeInterest(account);
        System.out.println(account.getMoney());

        requests.setNextRequest( new ChargeInterest(account)).setNextRequest(new ChargeInterest(account)).setNextRequest(new TakeFee(account));
        requests.execute();

        System.out.println(account.getMoney());
    }
}
