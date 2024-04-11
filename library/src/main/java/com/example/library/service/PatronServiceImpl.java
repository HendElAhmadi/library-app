package com.example.library.service;

import com.example.library.dtos.PatronDto;
import com.example.library.exception.BusinessException;
import com.example.library.mapper.PatronMapper;
import com.example.library.model.constants.ErrorCode;
import com.example.library.model.entity.Patron;
import com.example.library.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatronServiceImpl extends BaseServiceImpl<Patron,Long>implements PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private PatronMapper patronMapper;


    @Override
    public Boolean savePatron(PatronDto patronDto) {
        Patron patron=patronMapper.patronDtoToPatron(patronDto);
        save(patron);
        return true;
    }

    @Override
    public Boolean deletePatronById(Long id) {
        return deleteById(id);
    }

    @Override
    public Boolean updatePatronById(Long id, PatronDto patronDto) {
        Patron patron = getPatronByPatronId(id);
        patron=patronMapper.updatePatronFromPatronDto(patronDto,patron);
        save(patron);
        return true;
    }

    @Override
    public List<PatronDto> findPatronList() {
        return findAll().stream().map(patron -> patronMapper.patronToPatronDto(patron)).toList();
    }

    @Override
    public PatronDto findPatronById(Long id) {
        return patronMapper.patronToPatronDto(getPatronByPatronId(id));
    }

    @Override
    public Patron getPatronByPatronId(Long id){
        return findById(id).orElseThrow(() -> new BusinessException(ErrorCode.PATRON_NOT_FOUND.name(),ErrorCode.PATRON_NOT_FOUND.getErrorDesc()));
    }
}
