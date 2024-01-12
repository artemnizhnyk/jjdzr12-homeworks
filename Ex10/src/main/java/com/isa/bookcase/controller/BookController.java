package com.isa.bookcase.controller;

import com.isa.bookcase.dto.BookDto;
import com.isa.bookcase.service.BookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class BookController {

    private final BookService bookService;

    @GetMapping("/add")
    String showNeedRequestForm(Model model) {
        model.addAttribute("bookForm", new BookDto());
        model.addAttribute("categories", bookService.getBookCategories());
        model.addAttribute("forKids", List.of(true, false));
        return "add-book-form";
    }

    @PostMapping("/submit")
    String submitNeedRequestForm(@Valid @ModelAttribute("bookForm") BookDto bookForm, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("categories", bookService.getBookCategories());
            model.addAttribute("forKids", List.of(true, false));
            return "add-book-form";
        } else {
            bookService.addBook(bookForm);
            return "redirect:/books";
        }
    }
}