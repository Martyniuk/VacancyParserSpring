package com.test_spring.dao;

/**
 * Created by vladimir on 16.02.16.
 */
public interface GeneralDao<T> {

    void save(T t);
}
