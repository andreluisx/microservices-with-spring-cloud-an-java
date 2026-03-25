package com.rest_with_spring.rest_with_spring.exceptions;

import java.util.Date;

public record ExceptionResponse(
        Date timeStamp,
        String message,
        String details
) {}
