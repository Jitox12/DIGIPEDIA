package com.DIGIPEDIA.Digimon.Collection.exceptions;

public class EvolveException extends RuntimeException{

    private static final String GENERIC_DESCRIPTION = "evolution not accepted, ";

    public EvolveException(String detail) {
        super(GENERIC_DESCRIPTION.concat(detail));
    }
}
