package com.bookshop.bookshop.models;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String author;

    private double price;
}
