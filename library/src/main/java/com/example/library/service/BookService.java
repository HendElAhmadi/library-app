package com.example.library.service;

import com.example.library.dtos.BookDto;
import com.example.library.model.entity.Book;

import java.util.List;

public interface BookService extends BaseService<Book,Long>{

    Boolean saveBook (BookDto bookDto) ;

    Boolean deleteBookById(Long id) ;

    Boolean updateBookById(Long id,BookDto bookDto);

    List<BookDto> findBookList() ;

    BookDto findBookById(Long id);

    Book getBookByBookId(Long id);
}
