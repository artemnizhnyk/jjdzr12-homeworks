package com.isa.bookcase.dto.mapper;

import com.isa.bookcase.dto.BookDto;
import com.isa.bookcase.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDto toDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getAuthor().getName(),
                book.getTitle(),
                book.getCategory(),
                book.getPages(),
                book.getForKids()
        );
    }

    public Book toEntity(final BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .category(bookDto.getCategory())
                .pages(bookDto.getPages())
                .forKids(bookDto.getForKids())
                .build();
    }
}
