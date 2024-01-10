package com.isa.bookcase.repository;

import com.isa.bookcase.model.Author;

import java.util.Optional;

public interface AuthorRepository extends BaseJpaRepository<Author, Long> {

    Optional<Author> getAuthorByName(String name);
}
