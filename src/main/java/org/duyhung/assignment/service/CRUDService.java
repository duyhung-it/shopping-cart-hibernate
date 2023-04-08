package org.duyhung.assignment.service;


import java.util.List;

public interface CRUDService<T,K> {
    List<T> getAll();
    String insert(T t);
    Boolean delete(T t);
    Boolean update(T t);
    T getOne(K id);
}
