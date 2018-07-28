package com.lahiru;

import java.util.HashMap;

public class InMemoryRepository implements Repository<Account>{

    HashMap<Integer,Account> accountHashMap=new HashMap<Integer, Account>();

    @Override
    public void add(int id, Account item) {
        accountHashMap.put(id,item);
    }

    @Override
    public void update(int id, Account item) {
        accountHashMap.put(id,item);
    }

    @Override
    public void remove(int id) {
        accountHashMap.remove(id);
    }

    @Override
    public Account getById(int id) {
        return accountHashMap.get(id);
    }
}
