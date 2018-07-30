package com.lahiru.deprecate;


import java.util.HashMap;
import java.util.List;

public class InMemoryCompleteTransactionRepository implements Repository<Transaction> {
    HashMap<Integer,Transaction> completeTransactionHashMap =new HashMap<>();

    @Override
    public void add(int id, Transaction item) {
        completeTransactionHashMap.put(id,item);
    }

    @Override
    public int add(Transaction item) {
        return 0;
    }

    @Override
    public void update(int id, Transaction item) {
        completeTransactionHashMap.put(id,item);
    }

    @Override
    public void remove(int id) {
        completeTransactionHashMap.remove(id);
    }

    @Override
    public Transaction getById(int id) {
        Transaction transaction = completeTransactionHashMap.get(id);
        return transaction;
    }

    @Override
    public List<Transaction> query(Specification specification) {
        List<Transaction> result=specification.execute();
        return result;
    }
}
