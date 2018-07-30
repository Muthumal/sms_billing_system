package com.lahiru.deprecate;


public class CorporateAccount extends Account {

    private static final double CREDIT_LIMT = 30000.00;


    public CorporateAccount(int accountId) {
        super(CREDIT_LIMT, accountId);
    }

}
