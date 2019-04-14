package com.example.myapplication.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T t);
    void update(T t);
    T find(Integer id);
    void delete(T t);
    List<T> findAll();
}

