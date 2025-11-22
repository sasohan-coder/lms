package com.example.lms.Service;

import com.example.lms.model.StudentDb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDbService {
    private final List<StudentDb> studentList = new ArrayList<>();

    public StudentDb save(StudentDb student) {
        studentList.add(student);
        System.out.println("Student saved: " + student.getName() + ", Total students: " + studentList.size());
        return student;
    }

    public List<StudentDb> getAll() {
        System.out.println("Returning " + studentList.size() + " students");
        return new ArrayList<>(studentList);
    }
}