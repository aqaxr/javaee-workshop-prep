package com.dedalus.exception;

import javax.ws.rs.NotFoundException;

public class PetUnavailableException extends NotFoundException {
    public PetUnavailableException(Long id) {
        super("The pet " + id + " is not available for adoption.");
    }
}
