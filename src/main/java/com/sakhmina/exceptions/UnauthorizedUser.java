package com.sakhmina.exceptions;

public class UnauthorizedUser extends Throwable {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
