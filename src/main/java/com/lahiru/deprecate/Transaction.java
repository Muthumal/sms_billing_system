package com.lahiru.deprecate;


public class Transaction {

    private int id;
    private double amount;
    private int accountId;

    public Transaction(int id, double amount, int accountId) {
        this.id = id;
        this.amount = amount;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
