package org.espressif.exception.handler;

import com.fasterxml.jackson.core.JsonParseException;
import org.espressif.exception.ResourceNotFoundException;
import org.espressif.exception.dto.ErrorResponse;
import org.espressif.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Author: Ambikesh Shukla
 * This class is used to customize the error messages.
 *
 */
@Component
public class CacheExceptionHandler {

    public ResponseEntity<Object> getErrorResponse(Exception exception) {
        ErrorResponse error = null;
        if (exception instanceof JsonParseException) {
            String message = StringUtils.isEmpty(exception.getMessage()) ? Constants.BAD_REQUEST : exception.getMessage();
            error = new ErrorResponse(message, HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } else if (exception instanceof ResourceNotFoundException) {
            String message = StringUtils.isEmpty(exception.getMessage()) ? Constants.RESOURCE_NOT_FOUND : exception.getMessage();
            error = new ErrorResponse(message, HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } else {
            String message = StringUtils.isEmpty(exception.getMessage()) ? Constants.INTERNAL_SERVER_ERROR : exception.getMessage();
            error = new ErrorResponse(message, HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
