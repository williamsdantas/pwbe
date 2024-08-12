package br.edu.unipe.api.exception;


import java.time.LocalDateTime;


public class ErrorResponseDTO {
    private final String error;
    private final String message;
    private final String datail;
    LocalDateTime timestamp;

    public ErrorResponseDTO(String error, String message, String datail) {
        this.error = error;
        this.message = message;
        this.datail = datail;
        this.timestamp = LocalDateTime.now();
    }
}



