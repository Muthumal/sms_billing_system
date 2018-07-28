package com.lahiru;

import java.util.HashMap;
import java.util.Timer;

public class SmsBillingSystem implements BillingSystem {
    private double smsPrice=0.34;
    private HashMap<Integer,Timer> timerHashMap=new HashMap<>();
    private HashMap<Integer,Account> accountHashMap=new HashMap<>();
    private Repository repository;
    public SmsBillingSystem(Repository repository) {
        this.repository=repository;
    }


    @Override
    public int authorize(int simNo) {
        Account account = (Account) repository.getById(simNo);
        int transactionId = account.authorizeTransaction(getSmsPrice());
        if(transactionId==0){
            return transactionId;
        }
        accountHashMap.put(transactionId,account);
        createTimer(transactionId);
        return transactionId;
    }

    private void createTimer(int transactionId) {
        Timer timer = new CancelTimer(transactionId, this).createTimer();
        timerHashMap.put(transactionId,timer);
    }


    @Override
    public void confirm(int transactionNo) {
        accountHashMap.get(transactionNo).confirmTransaction(transactionNo);
        timerHashMap.get(transactionNo).cancel();
        timerHashMap.remove(transactionNo);
        accountHashMap.remove(transactionNo);
    }

    @Override
    public void cancel(int transactionNo) {
        accountHashMap.get(transactionNo).cancelTransaction(transactionNo);
        timerHashMap.remove(transactionNo);
        accountHashMap.remove(transactionNo);
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }


    public double getSmsPrice() {
        return smsPrice;
    }
}
