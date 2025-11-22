package com.example.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDb {
    private String name;
    private String title;
    private String author;
    private String publisher;
    private String description;
    private int stock;
}