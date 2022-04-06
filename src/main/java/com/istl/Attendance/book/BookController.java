package com.istl.Attendance.book;

import com.istl.Attendance.config.kafka.KafkaTopics;
import com.istl.Attendance.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public BookController(BookService bookService, KafkaProducerService kafkaProducerService) {
        this.bookService = bookService;
        this.kafkaProducerService = kafkaProducerService;
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
        kafkaProducerService.sendToKafka(KafkaTopics.NEW_BOOK_TOPIC,book.getIsbn(),book);
        //Book savedBook = bookService.addBook(book);
        //redirectAttributes.addFlashAttribute("savedBook", savedBook);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
        return redirectView;
    }
}
