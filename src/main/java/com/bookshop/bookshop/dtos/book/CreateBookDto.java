package com.bookshop.bookshop.dtos.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookDto {
    private String name;

    private String author;

    private double price;
}
