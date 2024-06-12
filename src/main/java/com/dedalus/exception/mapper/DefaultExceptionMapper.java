package com.dedalus.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        return Response.ok().status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
