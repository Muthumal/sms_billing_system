package com.lahiru.deprecate;


public class SmsBillingSystem implements BillingSystem {

    @Override
    public int authorize(int simNo) {

        return 0;
    }

    @Override
    public void confirm(int transactionNo) {

    }

    @Override
    public void cancel(int transactionNo) {

    }


}
