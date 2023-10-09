package com.isa.bootcamp.service;

import com.isa.bootcamp.entity.Book;
import com.isa.bootcamp.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Getter
@Setter
@AllArgsConstructor
public class BookService {

    private final BookRepository repository;

    public List<Book> getAllBooksList() {
        return repository.getBooks();
    }

    public Book getRandomBook() {
        return getAllBooksList().get(new Random().nextInt(getAllBooksList().size()));
    }

    public List<Book> getResultBookList(String title) {
        if (title.isBlank()) {
            return new ArrayList<>();
        }
        return getAllBooksList().stream()
                .filter(e -> e.title().toLowerCase().startsWith(title.toLowerCase()))
                .toList();
    }
}
