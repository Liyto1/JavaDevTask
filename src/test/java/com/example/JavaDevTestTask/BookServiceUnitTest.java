package com.example.JavaDevTestTask;
import com.example.JavaDevTestTask.book.BookEntity;
import com.example.JavaDevTestTask.book.dto.BookDto;
import com.example.JavaDevTestTask.book.mapper.BookMapper;
import com.example.JavaDevTestTask.book.repository.BookRepository;
import com.example.JavaDevTestTask.book.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookServiceUnitTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @Test
    public void testAddBook() {
        BookDto bookDto = new BookDto();
        bookDto.setTitle("Test Book");
        bookDto.setAuthor("Test Author");
        bookDto.setIsbn("1234567890123");
        bookDto.setQuantity(10);

        Mockito.when(bookMapper.bookDtoToBookEntity(bookDto)).thenReturn(new BookEntity());
        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(new BookEntity());
        Mockito.when(bookMapper.bookEntityToBookDto(Mockito.any(BookEntity.class))).thenReturn(bookDto);

        BookDto addedBook = bookService.addBook(bookDto);

        assertEquals(bookDto.getTitle(), addedBook.getTitle());
        assertEquals(bookDto.getAuthor(), addedBook.getAuthor());
        assertEquals(bookDto.getIsbn(), addedBook.getIsbn());
        assertEquals(bookDto.getQuantity(), addedBook.getQuantity());
    }

}
