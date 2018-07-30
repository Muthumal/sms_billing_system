package com.lahiru.deprecate;


public interface BillingSystem {

    int authorize(int simNo);
    void confirm(int transactionNo);
    void cancel(int transactionNo);

}
