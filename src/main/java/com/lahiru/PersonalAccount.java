package com.lahiru;

public class PersonalAccount extends Account {
    private double creditLimit=1500;
    public PersonalAccount() {
        super();
        setCreditLimit(creditLimit);
    }
}
