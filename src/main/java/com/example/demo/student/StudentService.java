package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(
                new Student("Kidus", LocalDate.of(2020, Month.FEBRUARY, 15)),
                new Student("Beza", LocalDate.of(2020, Month.SEPTEMBER, 14))
        );
    }
}
