package com.lahiru;

import java.util.Timer;
import java.util.TimerTask;

public class CancelTimer {

    private final int transactionId;
    private final BillingSystem smsBillingSystem;

    public CancelTimer(int transactionId, BillingSystem smsBillingSystem) {
        this.transactionId = transactionId;
        this.smsBillingSystem = smsBillingSystem;
    }

    public Timer createTimer() {
        Timer timer;
        timer=new Timer(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                smsBillingSystem.cancel(transactionId);
            }
        },60000);
        return timer;
    }
}
