package com.example.JavaDevTestTask.book.mapper;

import com.example.JavaDevTestTask.book.BookEntity;
import com.example.JavaDevTestTask.book.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface BookMapper {
        BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

        BookDto bookEntityToBookDto(BookEntity bookEntity);
        BookEntity bookDtoToBookEntity(BookDto bookDto);
        List<BookDto> bookEntitiesToBookDtos(List<BookEntity> allBooks);
}
