package com.lahiru.deprecate;


import java.util.List;

public interface Repository<T> {

    void add(int id, T item);

    int add(T item);

    void update(int id, T item);

    void remove(int id);

    T getById(int id);

    List<T> query(Specification specification);

}
