package br.com.dicasdeumdev.api.services.exceptions;

public class DataIntegrationViolationException extends RuntimeException{

    public DataIntegrationViolationException(String message) {
        super(message);
    }

}
