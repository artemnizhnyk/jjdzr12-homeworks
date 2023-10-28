package com.isa.bootcamp.repository;

import com.isa.bootcamp.entity.Book;
import com.isa.bootcamp.entity.Category;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Component
public class BookRepository {

    private final List<Book> books;

    BookRepository() {
        this.books = importBooks();
    }


    private static List<Book> importBooks() {
        return List.of(
                new Book("Hanya Yanagihara", "Małe życie", Category.LITERATURA_PIEKNA, 816, false),
                new Book("Maja Lunde", "Historia Pszczół", Category.LITERATURA_PIEKNA, 514, false),
                new Book("Leonie Swann", "Krocząc w ciemności", Category.LITERATURA_PIEKNA, 424, false),
                new Book("George R.R. Martin", "Gra o tron", Category.FANTASTYKA_SCIENCE_FICTION, 999, false),
                new Book("J.R.R. Tolkien", "Hobbit", Category.FANTASTYKA_SCIENCE_FICTION, 315, false),
                new Book("Simon Beckett", "Chemia śmierci", Category.KRYMINAL_SENSACJA_THRILLER, 352, false),
                new Book("Marc Elsberg", "Blackout", Category.KRYMINAL_SENSACJA_THRILLER, 784, false),
                new Book("Józef Ignacy Kraszewski", "Stara baśń", Category.HISTORYCZNA, 304, false),
                new Book("J.K. Rowling", "Harry Potter i Kamień Filozoficzny", Category.FANTASTYKA_SCIENCE_FICTION, 328, true),
                new Book("Antoine de Saint-Exupery", "Mały Książe", Category.LITERATURA_PIEKNA, 112, true),
                new Book("Jojo Moyes", "Zanim się pojawiłeś", Category.OBYCZAJOWA_ROMANS, 382, false),
                new Book("Elizabeth Gilbert", "Jedz, módl się, kochaj", Category.PUBLICYSTYKA_BIOGRAFIA, 490, false)
        );
    }
}