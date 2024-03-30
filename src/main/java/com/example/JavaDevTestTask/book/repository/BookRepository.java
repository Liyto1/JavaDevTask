package com.example.JavaDevTestTask.book.repository;

import com.example.JavaDevTestTask.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<Object> findById(UUID id);
    void deleteById(UUID id);
}
