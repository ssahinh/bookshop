package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dtos.book.CreateBookDto;
import com.bookshop.bookshop.dtos.book.GetBookDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@Api(value = "Book Api documentation")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ApiOperation(value = "New Book adding method")
    public ResponseEntity<CreateBookDto> addNewBook(@RequestBody CreateBookDto book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping
    @ApiOperation(value = "Get all books")
    public ResponseEntity<List<GetBookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

}
