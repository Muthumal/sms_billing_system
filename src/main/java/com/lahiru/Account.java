package com.lahiru;

import java.util.HashMap;
import java.util.Random;

public abstract class Account {

    private double creditLimit=0;

    private HashMap<Integer,Double> reserveTransaction   = new HashMap<>();
    private HashMap<Integer,Double> completedTransaction = new HashMap<>();

    protected Account() {
    }

    void setCreditLimit(double creditLimit){
        this.creditLimit=creditLimit;
    }

    public int authorizeTransaction(double price){
        double totalBill = getTotalBill(price);
        if(totalBill<=creditLimit){
            return generateTransactionId(price);
        }
        return 0;
    }

    private int generateTransactionId(double price) {
        while (true){
            int minimum=1;
            Random random=new Random();
            int transactionId = random.nextInt(Integer.MAX_VALUE-minimum)+minimum;
            if (reserveTransaction.containsKey(transactionId) || completedTransaction.containsKey(transactionId)) {
                continue;
            }else {
                reserveTransaction.put(transactionId,price);
                return transactionId;
            }


        }
    }

    private double getTotalBill(double price) {
        double totalBill=0;
        totalBill+= addValuesInHashMap(reserveTransaction);
        totalBill+= addValuesInHashMap(completedTransaction);
        totalBill+=price;
        return totalBill;
    }

    private double addValuesInHashMap(HashMap map) {
        double total=0;
        for (Object amount :map.values()) {
            total+=(double)amount;
        }
        return total;
    }

    public boolean cancelTransaction(int transactionId){
        Double remove = reserveTransaction.remove(transactionId);
        return remove!=null;
    }

    public boolean confirmTransaction(int transactionId){
        Double put = completedTransaction.put(transactionId, reserveTransaction.get(transactionId));
        Double remove = reserveTransaction.remove(transactionId);

        return put==null && remove!=null;
    }


}
