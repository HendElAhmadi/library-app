package com.example.library.web.controller;

import com.example.library.dtos.BookDto;
import com.example.library.service.BookService;
import com.example.library.web.response.ResponseModel;
import com.example.library.web.validation.BookValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    private BookValidator bookValidator;

    @InitBinder({"bookDto"})
    public void saveAndUpdateInitValidators(WebDataBinder binder) {
        binder.addValidators(bookValidator);
    }

    @PostMapping
    ResponseEntity<ResponseModel<Boolean>> saveBook(@Valid @RequestBody BookDto bookDto) {
        Boolean isBookSaved = bookService.saveBook(bookDto);
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .status(HttpStatus.OK.value()).data(isBookSaved).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }

    @GetMapping
    ResponseEntity<ResponseModel<List<BookDto>>> findBookList() {
        List<BookDto> bookDtoList = bookService.findBookList();
        ResponseModel<List<BookDto>> responseModel = ResponseModel.<List<BookDto>>builder()
                .status(HttpStatus.OK.value()).data(bookDtoList).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseModel<BookDto>> findBookById(@PathVariable Long id) {
        BookDto bookDto = bookService.findBookById(id);
        ResponseModel<BookDto> responseModel = ResponseModel.<BookDto>builder()
                .status(HttpStatus.OK.value()).data(bookDto).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseModel<Boolean>> deleteBookById(@PathVariable Long id) {
        Boolean isBookDeleted = bookService.deleteBookById(id);
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .status(HttpStatus.OK.value()).data(isBookDeleted).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseModel<Boolean>> updateBookById(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
        Boolean isBookUpdated = bookService.updateBookById(id, bookDto);
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .status(HttpStatus.OK.value()).data(isBookUpdated).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }


}
