package com.example.JavaDevTestTask;

import com.example.JavaDevTestTask.book.dto.BookDto;
import com.example.JavaDevTestTask.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
public class BookServiceIntegrationTest {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer()
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private BookService bookService;

    @Test
    public void testAddBook() {
        BookDto bookDto = new BookDto();
        bookDto.setTitle("Test Book");
        bookDto.setAuthor("Test Author");
        bookDto.setIsbn("1234567890123");
        bookDto.setQuantity(10);

        BookDto addedBook = bookService.addBook(bookDto);

        assertEquals(bookDto.getTitle(), addedBook.getTitle());
        assertEquals(bookDto.getAuthor(), addedBook.getAuthor());
        assertEquals(bookDto.getIsbn(), addedBook.getIsbn());
        assertEquals(bookDto.getQuantity(), addedBook.getQuantity());
    }


}
