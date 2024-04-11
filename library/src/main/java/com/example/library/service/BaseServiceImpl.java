package com.example.library.service;

import com.example.library.exception.BusinessException;
import com.example.library.model.constants.ErrorCode;
import com.example.library.model.entity.BaseEntity;
import com.example.library.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class BaseServiceImpl<T extends BaseEntity<ID>,ID extends Serializable> implements BaseService<T,ID> {

    @Autowired
    @Lazy
    private BaseRepository<T, ID> baseRepository;

    @Override
    @Transactional
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    @Transactional
    public Boolean deleteById(ID id) {
        try {
            baseRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException ex){
            throw new BusinessException(ErrorCode.ENTITY_NOT_FOUND.name(), ErrorCode.ENTITY_NOT_FOUND.getErrorDesc());
        }
    }

    @Override
    @Transactional(readOnly=true)
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }
}
