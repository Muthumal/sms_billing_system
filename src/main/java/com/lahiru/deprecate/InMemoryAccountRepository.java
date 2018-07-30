package com.lahiru.deprecate;

import java.util.HashMap;
import java.util.List;


public class InMemoryAccountRepository implements Repository<Account> {

    HashMap<Integer,Account> accountHashMap=new HashMap<Integer, Account>();

    @Override
    public void add(int id, Account item) {
        accountHashMap.put(id,item);
    }

    @Override
    public int add(Account item) {
        return 0;
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

    @Override
    public List<Account> query(Specification specification) {
        List<Account> result=specification.execute();
        return result;
    }

    public HashMap<Integer,Account> getAccountHashMap(){
        return accountHashMap;
    }
}
