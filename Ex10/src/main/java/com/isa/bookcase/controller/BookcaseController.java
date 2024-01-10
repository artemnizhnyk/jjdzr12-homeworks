package com.isa.bookcase.controller;

import com.isa.bookcase.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class BookcaseController {

    private final BookService bookService;

    @GetMapping("/books")
    String printBookList(Model model) {
        model.addAttribute("bookcase", bookService.getAllBooks());
        return "bookcase-view";
    }
}