package com.isa.bookcase.service;

import com.isa.bookcase.dto.BookDto;
import com.isa.bookcase.dto.mapper.BookMapper;
import com.isa.bookcase.enumeration.Category;
import com.isa.bookcase.model.Author;
import com.isa.bookcase.model.Book;
import com.isa.bookcase.repository.AuthorRepository;
import com.isa.bookcase.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @Override
    public Collection<BookDto> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        log.info("All books were fetched from the \"bookcase\" repository");
        return allBooks.stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public Set<Category> getBookCategories() {
        return EnumSet.allOf(Category.class);
    }

    @Override
    public void addBook(BookDto bookForm) {

        Optional<Author> author = authorRepository.getAuthorByName(bookForm.getAuthor().trim());

        Author savedAuthor = author.orElseGet(() -> {
            return authorRepository.saveAndFlush(
                    Author.builder()
                            .name(bookForm.getAuthor())
                            .build());
        });

        Book book = bookMapper.toEntity(bookForm);
        book.setAuthor(savedAuthor);

        bookRepository.save(book);
        log.info("Book \"" + bookForm.getTitle() + "\" was saved in the \"bookcase\" repository");
    }
}