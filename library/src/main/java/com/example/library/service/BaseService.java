package com.example.library.service;

import com.example.library.model.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {
    T save (T entity) ;

    Boolean deleteById(ID id) ;

    List<T> findAll() ;

    Optional<T> findById(ID id);
}
