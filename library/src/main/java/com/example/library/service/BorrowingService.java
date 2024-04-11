package com.example.library.service;


import com.example.library.dtos.BorrowingRecordDto;

import com.example.library.model.entity.BorrowingRecord;

public interface BorrowingService extends BaseService<BorrowingRecord,Long>{
    BorrowingRecordDto borrowABook (Long bookId, Long patronId) ;

}
