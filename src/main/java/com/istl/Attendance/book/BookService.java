package com.istl.Attendance.book;

import com.istl.Attendance.book.report.BookReportBean;
import com.istl.Attendance.book.report.BookSubReportBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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

    public List<Book> addBook(List<Book> books){
        try {
            return repository.saveAll(books);
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



    public Collection<BookReportBean> getBookReportBeans(){
        List<Book> books = repository.findAll();

        Collection<BookReportBean> bookReportBeans = new ArrayList<>();

        for (Book book: books)
        {
            List<BookSubReportBean> bookSubReportBeans = new ArrayList<>();
            bookSubReportBeans.add(new BookSubReportBean(book.getIsbn(),book.getName(),book.getAuthor()));

            BookReportBean tmp = BookReportBean.builder()
                    .isbn(book.getIsbn())
                    .name(book.getName())
                    .author(book.getAuthor())
                    .subReportBeanList(bookSubReportBeans)
                    .build();

            bookReportBeans.add(tmp);
        }

        return bookReportBeans;
    }


}
