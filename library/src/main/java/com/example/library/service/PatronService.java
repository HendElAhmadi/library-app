package com.example.library.service;


import com.example.library.dtos.PatronDto;
import com.example.library.model.entity.Patron;

import java.util.List;

public interface PatronService extends BaseService<Patron,Long>{

    Boolean savePatron (PatronDto patronDto) ;

    Boolean deletePatronById(Long id) ;

    Boolean updatePatronById(Long id,PatronDto patronDto);

    List<PatronDto> findPatronList() ;

    PatronDto findPatronById(Long id);

    Patron getPatronByPatronId(Long id);
}
