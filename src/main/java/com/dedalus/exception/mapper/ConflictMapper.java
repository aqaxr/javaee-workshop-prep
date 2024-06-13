package com.dedalus.exception.mapper;

import com.dedalus.exception.ConflictException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConflictMapper implements ExceptionMapper<ConflictException> {
    @Override
    public Response toResponse(ConflictException exception) {
        return Response.ok().status(Response.Status.CONFLICT).entity(exception.getMessage()).build();
    }
}
