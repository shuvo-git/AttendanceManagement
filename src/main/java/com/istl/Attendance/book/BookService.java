package com.istl.Attendance.book;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface BookService {
    Collection<Book> getBooks();
    Book addBook(Book book);
}
