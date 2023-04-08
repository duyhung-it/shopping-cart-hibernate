package org.duyhung.assignment.repository;

import java.util.List;

public interface CRUDRepository<T,K> {
    List<T> getAll();
    String insert(T t);
    Boolean delete(T t);
    Boolean update(T t);
    T getOne(K id);
}
