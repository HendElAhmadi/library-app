package com.example.library.web.controller;

import com.example.library.dtos.BorrowingRecordDto;
import com.example.library.service.BorrowingService;
import com.example.library.web.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/{bookId}/patron/{patronId}")
    ResponseEntity<ResponseModel<BorrowingRecordDto>> borrowBook(@PathVariable Long bookId,@PathVariable Long patronId) {
        BorrowingRecordDto borrowingRecordDto = borrowingService.borrowABook(bookId,patronId);
        ResponseModel<BorrowingRecordDto> responseModel = ResponseModel.<BorrowingRecordDto>builder()
                .status(HttpStatus.OK.value()).data(borrowingRecordDto).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }
}
