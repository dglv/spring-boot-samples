package ru.dglv.business.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public abstract class CrudServiceImpl<T, ID extends Serializable> implements CrudService<T, ID>
{
    @Autowired
    CrudRepository<T, ID> crudRepository;

    @Override
    public T save(final T entity)
    {
        return crudRepository.save(entity);
    }

    @Override
    public Iterable<T> save(final Iterable<T> entities)
    {
        return crudRepository.save(entities);
    }

    @Override
    public T find(final ID id)
    {
        return crudRepository.findOne(id);
    }

    @Override
    public Iterable<T> findAll()
    {
        return crudRepository.findAll();
    }
    
    @Override
    public void delete(final ID id)
    {
        crudRepository.delete(id);
    }

    @Override
    public void delete(final T entity)
    {
        crudRepository.delete(entity);
    }

    @Override
    public void delete(final Iterable<T> entities)
    {
        crudRepository.delete(entities);
    }

    @Override
    public void deleteAll()
    {
        crudRepository.deleteAll(); 
    }
}
