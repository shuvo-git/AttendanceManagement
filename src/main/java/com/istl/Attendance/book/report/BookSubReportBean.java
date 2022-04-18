package com.istl.Attendance.book.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class BookSubReportBean
{
    private String isbn;
    private String name;
    private String author;
}
