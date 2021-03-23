package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.SEPTEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            repository.saveAll(
                    List.of(
                            new Student("Kidus",
                                    LocalDate.of(1996, FEBRUARY, 15),
                                    "kidusmt@gmail.com"),
                            new Student("Beza",
                                    LocalDate.of(1995, SEPTEMBER, 14),
                                    "beza@gmail.com")
                    )
            );
        };
    }
}
