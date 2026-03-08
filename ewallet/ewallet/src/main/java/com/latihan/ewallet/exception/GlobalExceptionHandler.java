package com.latihan.ewallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WalletNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleWalletNotFoundException(WalletNotFoundException ex){
        return ex.getMessage();
    }

}
