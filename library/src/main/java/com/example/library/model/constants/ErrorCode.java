package com.example.library.model.constants;

public enum ErrorCode {
    ENTITY_NOT_FOUND("Entity is not found!"),
    ACCESS_IS_NOT_ALLOWED("Access is not Allowed"),
    SOMETHING_WENT_WRONG("Something went wrong"),
    TOKEN_IS_NEEDED("Token is required"),
    INVALID_TOKEN("Token is invalid"),
    EXPIRED_TOKEN("Token is expired"),
    INVALID_CREDENTIALS("Credentials are not valid"),
    BOOK_NOT_FOUND("Book is not found"),
    PATRON_NOT_FOUND("Patron is not found"),
    BOOK_TITLE_MUST_NOT_BE_NULL("Book title must not be empty"),
    BOOK_AUTHOR_MUST_NOT_BE_NULL("Book author name must not be empty"),
    BOOK_ISBN_MUST_NOT_BE_NULL("Book ISBN must not be empty"),
    BOOK_PUBLICATION_DATE_MUST_NOT_BE_NULL("Book publication date must not be empty"),
    PATRON_CONTACT_MUST_NOT_BE_NULL("Patron contact number must not be empty"),
    PATRON_NAME_MUST_NOT_BE_NULL("Patron name must not be empty"),
    PATRON_EMAIL_MUST_NOT_BE_NULL("Patron email must not be empty"),
    PATRON_EMAIL_NOT_VALID("Patron email is not valid\""),
    PATRON_MOBILE_NOT_VALID("Patron contact number is not valid"),
    BORROWING_FAILED("Book is already borrowed");

    private String errorDesc;

    ErrorCode(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
