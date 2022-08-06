package com.sakhmina.exceptions;

public class InvalidCredentials extends Throwable {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
