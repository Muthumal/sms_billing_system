package com.lahiru;

public interface BillingSystem {
    int authorize(int simNo);
    void confirm(int transactionNo);
    void cancel(int transactionNo);
}
