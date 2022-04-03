package com.istl.Attendance.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class Book {

    @Id
    private String isbn;

    private String name;

    private String author;
}
