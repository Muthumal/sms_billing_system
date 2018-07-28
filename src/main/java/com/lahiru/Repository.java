package com.lahiru;

public interface Repository<T> {
    void add(int id,T item);

    void update(int id,T item);

    void remove(int id);

    T getById(int id);
}
