package com.example.library.service;


import com.example.library.dtos.BookDto;
import com.example.library.exception.BusinessException;
import com.example.library.mapper.BookMapper;
import com.example.library.model.constants.ErrorCode;
import com.example.library.model.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, Long>  implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    @Override
    public Boolean saveBook(BookDto bookDto) {
        Book book = bookMapper.bookDtoToBook(bookDto);
        save(book);
        return true;
    }

    @Override
    public Boolean deleteBookById(Long id) {
        return deleteById(id);
    }

    @Override
    public Boolean updateBookById(Long id,BookDto bookDto) {
        Book book=getBookByBookId(id);
        book=bookMapper.updateBookFromBookDto(bookDto,book);
        save(book);
        return true;
    }

    @Override
    public List<BookDto> findBookList() {
        return findAll().stream().map(book -> bookMapper.bookToBookDto(book)).toList();
    }

    @Override
    public BookDto findBookById(Long id) {
        return bookMapper.bookToBookDto(getBookByBookId(id));
    }

    @Override
    public Book getBookByBookId(Long id){
        return findById(id).orElseThrow(() -> new BusinessException(ErrorCode.BOOK_NOT_FOUND.name(),ErrorCode.BOOK_NOT_FOUND.getErrorDesc()));
    }
}
