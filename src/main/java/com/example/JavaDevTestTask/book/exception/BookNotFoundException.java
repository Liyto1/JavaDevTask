package com.example.JavaDevTestTask.book.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}