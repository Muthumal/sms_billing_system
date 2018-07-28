package com.lahiru;

public class CorporateAccount extends Account {
    private double creditLimit=30000;
    public CorporateAccount() {
        super();
        setCreditLimit(creditLimit);
    }
}
