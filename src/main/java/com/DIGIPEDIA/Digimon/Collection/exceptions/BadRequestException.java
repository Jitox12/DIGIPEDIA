package com.DIGIPEDIA.Digimon.Collection.exceptions;


public class BadRequestException extends RuntimeException {

    private static final String GENERIC_DESCRIPTION = "Invalid Request with: ";

    public BadRequestException(String detail) {
        super(GENERIC_DESCRIPTION.concat(detail));
    }
}