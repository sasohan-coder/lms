package com.example.lms.Dto;

public record BookSubmitDto(String bookName,
                            String studentName,
                            String type,
                            int count) {


    // Default constructor for Thymeleaf binding
    public BookSubmitDto() {
        this("", "", "", 0);
    }

}
