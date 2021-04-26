package com.jm.students.service;

import java.util.List;

public interface AbstractEntityService<T> {
    public T findById(Long id);

    public List<T> findAll();

    public void remove(T entity);

    public void removeById(Long id);

    public Boolean isExistById(Long id);

    public void save(T entity);

    public T update(T entity);
}
