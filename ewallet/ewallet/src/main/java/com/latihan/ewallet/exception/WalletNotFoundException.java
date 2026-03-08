package com.latihan.ewallet.exception;

public class WalletNotFoundException extends RuntimeException
{
    public WalletNotFoundException(String message)
    {
        super(message);
    }
}
