package com.dedalus.exception;

import javax.ws.rs.NotFoundException;

public class ConflictException extends RuntimeException {
    public ConflictException(Long id) {
        super("The pet " + id + " is not adopted, it cannot be renamed.");
    }
}
