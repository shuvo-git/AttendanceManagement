package com.istl.Attendance.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/viewBooks")
    public String index(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "index";
    }

    @GetMapping("/addBook")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/addBook")
    public RedirectView store(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/book/addBook", true);
        Book savedBook = bookService.addBook(book);
        redirectAttributes.addFlashAttribute("savedBook", savedBook);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
        return redirectView;
    }
}
