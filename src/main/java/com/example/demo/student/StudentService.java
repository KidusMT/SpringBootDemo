package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void registerStudent(Student student){
        Optional<Student> studentOptional = repository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("user existed");
        }
        repository.save(student);
    }
}
