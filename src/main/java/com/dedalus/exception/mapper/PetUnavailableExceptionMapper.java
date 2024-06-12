package com.dedalus.exception.mapper;

import com.dedalus.exception.PetUnavailableException;

import javax.ws.rs.core.Response;

public class PetUnavailableExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<PetUnavailableException> {
    @Override
    public Response toResponse(PetUnavailableException exception) {
        return Response.ok().status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
