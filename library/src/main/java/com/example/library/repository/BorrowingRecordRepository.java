package com.example.library.repository;

import com.example.library.model.entity.Book;
import com.example.library.model.entity.BorrowingRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends BaseRepository<BorrowingRecord,Long> {

    List<BorrowingRecord> findByBook(Book book);
}
