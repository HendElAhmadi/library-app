package com.example.library.repository;

import com.example.library.model.entity.Patron;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends BaseRepository<Patron,Long> {
}
