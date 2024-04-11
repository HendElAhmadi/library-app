package com.example.library.web.validation;


import com.example.library.dtos.BookDto;
import com.example.library.exception.BadRequestException;
import com.example.library.model.constants.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.Objects;


@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BookDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto bookDto=(BookDto) target;
        validateBookTitle(bookDto.getTitle());
        validateBookAuthorName(bookDto.getAuthor());
        validateBookPublicationDate(bookDto.getPublicationDate());
        validateBookISBN(bookDto.getInternationalStandardBookNumber());
    }

    private void validateBookISBN(String isbn) {
        if (Objects.isNull(isbn) || isbn.isEmpty() || isbn.isBlank()) {
            throw new BadRequestException(ErrorCode.BOOK_ISBN_MUST_NOT_BE_NULL.name(),
                    ErrorCode.BOOK_ISBN_MUST_NOT_BE_NULL.getErrorDesc());
        }
    }

    private void validateBookPublicationDate(LocalDate publicationDate) {
        if (Objects.isNull(publicationDate)) {
            throw new BadRequestException(ErrorCode.BOOK_PUBLICATION_DATE_MUST_NOT_BE_NULL.name(),
                    ErrorCode.BOOK_PUBLICATION_DATE_MUST_NOT_BE_NULL.getErrorDesc());
        }
    }

    private void validateBookAuthorName(String author) {
        if (Objects.isNull(author) || author.isEmpty() || author.isBlank()) {
            throw new BadRequestException(ErrorCode.BOOK_AUTHOR_MUST_NOT_BE_NULL.name(),
                    ErrorCode.BOOK_AUTHOR_MUST_NOT_BE_NULL.getErrorDesc());
        }
    }

    private void validateBookTitle(String title) {
        if (Objects.isNull(title) || title.isEmpty() || title.isBlank()) {
            throw new BadRequestException(ErrorCode.BOOK_TITLE_MUST_NOT_BE_NULL.name(),
                    ErrorCode.BOOK_TITLE_MUST_NOT_BE_NULL.getErrorDesc());
        }
    }
}
