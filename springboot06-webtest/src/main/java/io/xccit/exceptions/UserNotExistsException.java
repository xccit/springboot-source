package io.xccit.exceptions;

/**
 * @author CH_ywx
 * @date 2023-08-03
 * @description
 */
public class UserNotExistsException extends RuntimeException{
    public UserNotExistsException(String message) {
        super(message);
    }
}
