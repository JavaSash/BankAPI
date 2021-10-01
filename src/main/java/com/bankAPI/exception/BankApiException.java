package com.bankAPI.exception;

public class BankApiException extends RuntimeException {
    private String uuid;

    public BankApiException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public BankApiException(String message) {
        super(message);
    }

    public String getUuid() {
        return uuid;
    }
}

