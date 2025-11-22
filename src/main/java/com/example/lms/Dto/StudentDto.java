package com.example.lms.Dto;

import com.example.lms.model.StudentDb;

public record StudentDto(
        String name,
        String email,
        String mobile) {

    public StudentDb toStudent() {
        return new StudentDb(name, email, mobile);
    }
}