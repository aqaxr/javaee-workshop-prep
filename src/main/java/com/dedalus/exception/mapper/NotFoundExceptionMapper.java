package com.dedalus.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<javax.ws.rs.NotFoundException> {
    @Override
    public Response toResponse(javax.ws.rs.NotFoundException exception) {
        return Response.ok().status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
