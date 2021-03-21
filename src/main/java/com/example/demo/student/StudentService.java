package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        repository = studentRepository;
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }
}
