package br.edu.unipe.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalHandlerException {

    public ResponseEntity<ErrorResponseDTO> handlerException(Exception ex) {
        ErrorResponseDTO errorResponseDTO =
                new ErrorResponseDTO("Internal Error Server", ex.getMessage(),null);

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

