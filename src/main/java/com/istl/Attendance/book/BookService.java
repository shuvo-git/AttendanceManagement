package com.istl.Attendance.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class BookService
{
    //Map<String, Book> books = new HashMap<>();
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Collection<Book> getBooks(){
        return repository.findAll();
    }
    public Book addBook(Book book){
        try {
            return repository.save(book);
        }
        catch (Exception e){
            return null;
        }
    }


}
