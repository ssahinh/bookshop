package com.bookshop.bookshop.dtos.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookDto {
    private String name;

    private String author;

    private double price;
}
