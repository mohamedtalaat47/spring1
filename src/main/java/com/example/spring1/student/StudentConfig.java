package com.example.spring1.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mohamed = new Student("Mohamed", "test@test.com", LocalDate.of(1998, Month.AUGUST, 27));
            Student ahmed = new Student("Ahmed", "test2@test.com", LocalDate.of(1978, Month.APRIL, 20));
            repository.saveAll(List.of(mohamed,ahmed));
        };
    }    
}
