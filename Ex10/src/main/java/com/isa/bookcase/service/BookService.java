package com.isa.bookcase.service;

import com.isa.bookcase.dto.BookDto;
import com.isa.bookcase.enumeration.Category;

import java.util.Collection;
import java.util.Set;

public interface BookService {

    Collection<BookDto> getAllBooks();

    Set<Category> getBookCategories();

    void addBook(BookDto bookForm);
}