package com.lahiru.deprecate;


public abstract class Account {

    private double creditLimit;
    private int accountId;

    public Account(double creditLimit, int accountId) {
        this.creditLimit = creditLimit;
        this.accountId = accountId;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
