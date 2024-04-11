package com.example.library.repository;

import com.example.library.model.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book,Long> {
}
