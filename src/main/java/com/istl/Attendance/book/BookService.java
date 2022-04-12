package com.istl.Attendance.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class BookService
{
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

    public boolean deleteBook(String isbn){
        Book book = null;
        try {
            book = repository.findById(isbn).orElse(null);
            if(book==null)
                return false;

            repository.delete(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
