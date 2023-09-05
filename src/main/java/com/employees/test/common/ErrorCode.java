package com.employees.test.common;

public enum ErrorCode {
    GENERIC_ERROR( "GENERIC_ERROR", "An error occurred.", 1),
    TOO_MANY_REQUESTS( "TOO_MANY_REQUESTS", "Too many requests. Please try again later.", 2),
    BAD_REQUEST( "BAD_REQUEST", "Bad request error please try again later.", 3),
    FORMAT_ERROR( "FORMAT_ERROR", "Invalid request format.", 4),
    CLIENT_ERROR( "CLIENT_ERROR", "external client error.", 5);
    
    // GENERIC_ERROR( "GENERIC_ERROR","generic.error", 1),
    // TOO_MANY_REQUESTS( "TOO_MANY_REQUESTS","many.request", 2),
    // BAD_REQUEST( "BAD_REQUEST","bad.request", 3),
    // FORMAT_ERROR( "FORMAT_ERROR","format.error", 4),
    // CLIENT_ERROR( "CLIENT_ERROR","client.error", 5);
    
    private final String code;
    private final String message;
    private final Integer id;

    ErrorCode(String code, String message, Integer id) {
        this.id = id;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }

}
