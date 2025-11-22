package com.example.lms.Dto;

import com.example.lms.model.BookDb;

public record BookDto(
        String name,
        String title,
        String author,
        String publisher,
        String description,
        int stock) {

    public BookDb toBook() {
        return new BookDb(name, title, author, publisher, description, stock);
    }
}