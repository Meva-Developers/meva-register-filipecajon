package com.meva.finance.api.exception;

import org.springframework.http.HttpStatus;

public class InvalidFamilyException extends RuntimeException {
    public InvalidFamilyException(String familyIdNotExist, HttpStatus httpStatus) {

    }
}
