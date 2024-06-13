package com.dedalus.exception.mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.ValidationException;

public class ConstraintValidationExceptionMapper {
    @Provider
    public class ContstraintValidationExceptionMapper implements ExceptionMapper<ValidationException> {
        @Override
        public Response toResponse(ValidationException exception) {
            return Response.status(442)
                    .entity("Thou shall respect the constraints!")
                    .build();
        }
    }
}
