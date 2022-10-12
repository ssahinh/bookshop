package com.bookshop.bookshop.services;

import com.bookshop.bookshop.dtos.book.CreateBookDto;
import com.bookshop.bookshop.dtos.book.GetBookDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public CreateBookDto addBook(CreateBookDto createBookDto) {
        Book book = Book.builder()
                .author(createBookDto.getAuthor())
                .name(createBookDto.getName())
                .price(createBookDto.getPrice())
                .build();

        bookRepository.save(book);
        return createBookDto;
    }

    public List<GetBookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToGetBookDto)
                .toList();
    }

    public GetBookDto convertToGetBookDto(Book book) {
        return new GetBookDto(
                book.getName(),
                book.getAuthor(),
                book.getPrice()
        );
    }
}
