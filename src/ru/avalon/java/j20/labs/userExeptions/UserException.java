package ru.avalon.java.j20.labs.userExeptions;

public class UserException extends Exception {
    private int code;
    private String msg;

    public UserException(String msg) {
        this.msg = msg;
    }

    public UserException(int а) {
        this.code = а;
    }

    public String toString() {

        return "UserException [" + this.msg + "] ";
    }
}
