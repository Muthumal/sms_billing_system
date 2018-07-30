package com.lahiru.deprecate;


import java.util.HashMap;
import java.util.List;

public class InMemoryReserveTransactionRepository implements Repository<Transaction> {

    HashMap<Integer, Transaction> reserveTransactionHashMap=new HashMap<>();

    @Override
    public void add(int id, Transaction item) {
        reserveTransactionHashMap.put(id,item);
    }

    @Override
    public int add(Transaction item) {
        return 0;
    }

    @Override
    public void update(int id, Transaction item) {
        reserveTransactionHashMap.put(id,item);
    }

    @Override
    public void remove(int id) {
        reserveTransactionHashMap.remove(id);
    }

    @Override
    public Transaction getById(int id) {
        return reserveTransactionHashMap.get(id);
    }

    @Override
    public List<Transaction> query(Specification specification) {
        List<Transaction> result=specification.execute();
        return result;
    }

}
