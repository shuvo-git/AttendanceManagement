package com.istl.Attendance.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class BookService
{
    Map<String, Book> books = new HashMap<>();

    public Collection<Book> getBooks(){
        return new ArrayList<>(books.values());
    }
    public Book addBook(Book book){
        try {
            books.put(book.getIsbn(),book);
            return books.get(book.getIsbn());
        }
        catch (Exception e){
            return null;
        }
    }


}
