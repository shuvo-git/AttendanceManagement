package com.istl.Attendance.book.report;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BookReportBean
{
    private String isbn;
    private String name;
    private String author;

    private List<BookSubReportBean> subReportBeanList;
}
