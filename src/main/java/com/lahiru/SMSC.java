package com.lahiru;

public class SMSC {
    public static void main(String [] args){
        Repository repository=new DummyAccountStore().buildRepository();
        BillingSystem smsBillingSystem = new SmsBillingSystem(repository);

        int authorize = smsBillingSystem.authorize(716484641);
        System.out.println(authorize);
    }
}
