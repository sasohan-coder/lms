package com.example.lms.Dto;

public class BookSubmitDto {
    private String bookName;
    private String studentName;
    private String type;
    private int count;

    // Default Constructor
    public BookSubmitDto() {}

    // Parameterized Constructor
    public BookSubmitDto(String bookName, String studentName, String type, int count) {
        this.bookName = bookName;
        this.studentName = studentName;
        this.type = type;
        this.count = count;
    }

    // Getters and Setters
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}