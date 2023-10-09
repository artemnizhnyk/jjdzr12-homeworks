package com.isa.bootcamp.controller;

import com.isa.bootcamp.entity.Book;
import com.isa.bootcamp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
public class BookController {

    private final BookService service;

    @GetMapping("/")
    public String helloFromArtemLibrary(Model model) {
        model.addAttribute("content", "index");
        return "main";
    }

    @GetMapping("/books")
    public String showAllBooks(Model model) {
        List<Book> allBooksList = service.getAllBooksList();
        model.addAttribute("booksList", allBooksList);
        model.addAttribute("content", "books");
        return "main";
    }

    @GetMapping("/book-for-today")
    public String showBookForToday(Model model) {
        model.addAttribute("randomBook", service.getRandomBook());
        model.addAttribute("content", "book-for-today");
        return "main";
    }

    @GetMapping("/books/{title}")
    public String showBook(Model model, @PathVariable String title) {
        model.addAttribute("booksList", service.getResultBookList(title));
        model.addAttribute("content", "books");
        return "main";
    }

    @PostMapping("/books")
    public String searchBooks(@RequestParam String searchQuery) {
        if (searchQuery.isEmpty()) {
            return "redirect:/books/noBooks";
        }
        return "redirect:/books/" + searchQuery;
    }

    @GetMapping("/artem-hyena-face")
    public String fullscreenArtemHyenaFace(Model model) {
        model.addAttribute("content", "artem-hyena-face");
        return "main";
    }
}
