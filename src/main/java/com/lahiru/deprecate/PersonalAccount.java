package com.lahiru.deprecate;


public class PersonalAccount extends Account {

    private static final double CREDIT_LIMT = 1500;

    public PersonalAccount(int accountId) {
        super(CREDIT_LIMT, accountId);
    }
}
