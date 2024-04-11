package com.example.library.service;

import com.example.library.dtos.BorrowingRecordDto;
import com.example.library.exception.BusinessException;
import com.example.library.model.constants.ErrorCode;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.BorrowingRecord;
import com.example.library.model.entity.Patron;
import com.example.library.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingServiceImpl extends BaseServiceImpl<BorrowingRecord,Long>implements BorrowingService {

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Override
    public BorrowingRecordDto borrowABook(Long bookId, Long patronId) {
        Book book = bookService.getBookByBookId(bookId);
        Patron patron = patronService.getPatronByPatronId(patronId);
        List<BorrowingRecord> borrowingRecordList =borrowingRecordRepository.findByBook(book);
        boolean isBookBorrowed = borrowingRecordList.stream().anyMatch(borrowingRecord -> borrowingRecord.getHasReturned().equals(false));
        if (isBookBorrowed)
            throw new BusinessException(ErrorCode.BORROWING_FAILED.name(), ErrorCode.BORROWING_FAILED.getErrorDesc());
        BorrowingRecord borrowingRecord2 = BorrowingRecord.builder().book(book).patron(patron).returnDate(LocalDateTime.now().plusDays(7)).hasReturned(false).build();
        borrowingRecord2=save(borrowingRecord2);
        return BorrowingRecordDto.builder().returnDate(borrowingRecord2.getReturnDate()).build();
    }
}
