package com.istl.Attendance.services;

import com.istl.Attendance.book.Book;
import com.istl.Attendance.book.BookService;
import com.istl.Attendance.config.kafka.KafkaTopics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {
    private final BookService bookService;

    @Autowired
    public KafkaConsumerService(BookService bookService) {
        this.bookService = bookService;
    }

    @KafkaListener(groupId = "newBookTopicGroup", topics = KafkaTopics.NEW_BOOK_TOPIC)
    public void listenCaseSubmit(Book object) {
        log.info("Received: " + object);
        if(object != null)
        {
            log.info("Handling New Book Request");
            bookService.addBook((Book) object);
        } else {
            return;
        }

    }
}
