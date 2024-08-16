package br.edu.unipe.api.exception;

public class AtivoNotFoundException extends RuntimeException{
    public AtivoNotFoundException(String message){
        super(message);
    }
}
