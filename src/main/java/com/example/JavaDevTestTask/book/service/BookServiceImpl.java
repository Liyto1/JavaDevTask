package com.example.JavaDevTestTask.book.service;


import com.example.JavaDevTestTask.book.BookEntity;
import com.example.JavaDevTestTask.book.dto.BookDto;
import com.example.JavaDevTestTask.book.exception.BookNotFoundException;
import com.example.JavaDevTestTask.book.mapper.BookMapper;
import com.example.JavaDevTestTask.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDto addBook(BookDto bookDto) {
        BookEntity bookEntity = bookMapper.bookDtoToBookEntity(bookDto);
        BookEntity savedBook = bookRepository.save(bookEntity);
        return bookMapper.bookEntityToBookDto(savedBook);
    }

    @Override
    public BookDto getBook(UUID id) {
        BookEntity bookEntity = (BookEntity) bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        return bookMapper.bookEntityToBookDto(bookEntity);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> allBooks = bookRepository.findAll();
        // Map the list of entities to a list of DTOs
        return bookMapper.bookEntitiesToBookDtos(allBooks);
    }

    @Override
    public BookDto updateBook(UUID id, BookDto bookDto) {
        BookEntity existingBook = (BookEntity) bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setIsbn(bookDto.getIsbn());
        existingBook.setQuantity(bookDto.getQuantity());
        BookEntity updatedBook = bookRepository.save(existingBook);
        return bookMapper.bookEntityToBookDto(updatedBook);
    }

    @Override
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
