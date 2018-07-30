package com.lahiru;

import java.util.concurrent.TimeUnit;

public class SMSC {
    public static void main(String [] args){
        Repository repository = new initRepository().buildRepository();
        BillingSystem smsBillingSystem = new SmsBillingSystem(repository);

        int authorize = smsBillingSystem.authorize(716484641);
        System.out.println(authorize);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        authorize = smsBillingSystem.authorize(716484643);
        System.out.println(authorize);
        smsBillingSystem.confirm(authorize);
        System.out.println("Confirm transaction "+authorize);

    }
}
