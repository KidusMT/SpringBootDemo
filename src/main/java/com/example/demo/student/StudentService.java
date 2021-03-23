package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        repository = studentRepository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void registerStudent(Student student) {
        Optional<Student> studentOptional = repository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("user existed");
        }
        repository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (repository.findById(studentId).isEmpty()) {
            throw new IllegalStateException("user with id:" + studentId + " doesn't exist");
        }
        repository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student doesn't exist."));
        if (name != null && name.length() > 0 &&
                !name.equals(student.getName())) {
            student.setName(name);
        }

        if (email != null && email.length() > 0) {
            Optional<Student> studentOptional = repository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already exist.");
            }
            student.setEmail(email);
        }

    }
}
