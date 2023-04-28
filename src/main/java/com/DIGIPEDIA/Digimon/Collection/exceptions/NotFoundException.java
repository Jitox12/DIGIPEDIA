package com.DIGIPEDIA.Digimon.Collection.exceptions;

public class NotFoundException extends RuntimeException{
    private static final String GENERIC_DESCRIPTION = "Not Found any ";

    public NotFoundException(String detail) {
        super(GENERIC_DESCRIPTION.concat(detail));
    }
}