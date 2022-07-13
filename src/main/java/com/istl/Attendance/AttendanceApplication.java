package com.istl.Attendance;

import com.istl.Attendance.book.Book;
import com.istl.Attendance.book.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class AttendanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.istl.Attendance")).build();
	}


	@Bean
	CommandLineRunner run(BookService bookService){
		return args->{

			List<Book> books = new ArrayList<>();

			books.add(new Book("3","Book3","Auth3"));
			books.add(new Book("4","Book4","Auth4"));
			books.add(new Book("5","Book5","Auth5"));
			books.add(new Book("6","Book6","Auth6"));
			books.add(new Book("7","Book7","Auth7"));
			books.add(new Book("8","Book8","Auth8"));
			books.add(new Book("10","Book10","Auth10"));

			bookService.addBook(books);

		};
	}



}
