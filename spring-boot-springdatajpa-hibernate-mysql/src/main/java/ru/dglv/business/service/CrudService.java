package ru.dglv.business.service;

import java.io.Serializable;

public interface CrudService<T, ID extends Serializable>
{
    T save(T entity);
    Iterable<T> save(Iterable<T> entities);
    T find(ID id);
    Iterable<T> findAll();
    void delete(ID id);
    void delete(T entity);
    void delete(Iterable<T> entities);
    void deleteAll();
}
