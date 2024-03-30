package com.example.JavaDevTestTask.book.service;

import com.example.JavaDevTestTask.book.dto.BookDto;
import com.example.JavaDevTestTask.book.exception.BookNotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookDto addBook(BookDto bookDto);
    BookDto getBook(UUID id) throws BookNotFoundException;
    List<BookDto> getAllBooks();
    BookDto updateBook(UUID id, BookDto bookDto);
    void deleteBook(UUID id);

}
