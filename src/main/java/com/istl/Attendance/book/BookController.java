package com.istl.Attendance.book;

import com.istl.Attendance.config.kafka.KafkaTopics;
import com.istl.Attendance.services.KafkaProducerService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
import java.util.HashMap;

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
    public RedirectView store(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes)
    {
        final RedirectView redirectView = new RedirectView("/book/addBook", true);
        kafkaProducerService.sendToKafka(KafkaTopics.NEW_BOOK_TOPIC,book.getIsbn(),book);
        //Book savedBook = bookService.addBook(book);
        //redirectAttributes.addFlashAttribute("savedBook", savedBook);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
        return redirectView;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable String id, RedirectAttributes redirectAttributes)
    {
        final RedirectView redirectView = new RedirectView("/book/viewBooks", true);
        kafkaProducerService.sendToKafka(KafkaTopics.DELETE_BOOK_TOPIC,id,id);

        redirectAttributes.addFlashAttribute("viewBookSuccess", true);
        return redirectView;
    }

    @GetMapping("/report")
    public String generateReport() throws FileNotFoundException, JRException
    {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookService.getBooks());
        JasperReport compileReport = JasperCompileManager.compileReport(
                this.getClass().getResourceAsStream("/report/report-groupby-template2.jrxml"));

        HashMap<String, Object> map = new HashMap<>();
        JasperPrint print = JasperFillManager.fillReport(compileReport,map,dataSource);

        JasperExportManager.exportReportToPdfFile(print,"book_report.pdf");

        return "generated";
    }
}
