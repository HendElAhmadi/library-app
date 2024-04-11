package com.example.library.web.validation;

import com.example.library.dtos.PatronDto;
import com.example.library.exception.BadRequestException;
import com.example.library.model.constants.Constants;
import com.example.library.model.constants.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class PatronValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PatronDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PatronDto patronDto =(PatronDto) target;
        validatePatronName(patronDto.getName());
        validatePatronContact(patronDto.getContact());
        validatePatronEmail(patronDto.getEmail());
    }

    private void validatePatronEmail(String email) {
        if (Objects.isNull(email) || email.isEmpty() || email.isBlank()) {
            throw new BadRequestException(ErrorCode.PATRON_EMAIL_MUST_NOT_BE_NULL.name(),
                    ErrorCode.PATRON_EMAIL_MUST_NOT_BE_NULL.getErrorDesc());
        }else if (!email.matches(Constants.EMAIL_REGEX)) {
            throw new BadRequestException(ErrorCode.PATRON_EMAIL_NOT_VALID.name(),
                    ErrorCode.PATRON_EMAIL_NOT_VALID.getErrorDesc());
        }
    }

    private void validatePatronContact(String contact) {
        if (Objects.isNull(contact) || contact.isEmpty() || contact.isBlank()) {
            throw new BadRequestException(ErrorCode.PATRON_CONTACT_MUST_NOT_BE_NULL.name(),
                    ErrorCode.PATRON_CONTACT_MUST_NOT_BE_NULL.getErrorDesc());
        }else if (!contact.matches(Constants.MOBILE_REGEX)) {
            throw new BadRequestException(ErrorCode.PATRON_MOBILE_NOT_VALID.name(),
                    ErrorCode.PATRON_MOBILE_NOT_VALID.getErrorDesc());
        }
    }

    private void validatePatronName(String name) {
        if (Objects.isNull(name) || name.isEmpty() || name.isBlank()) {
            throw new BadRequestException(ErrorCode.PATRON_NAME_MUST_NOT_BE_NULL.name(),
                    ErrorCode.PATRON_NAME_MUST_NOT_BE_NULL.getErrorDesc());
        }
    }
}
