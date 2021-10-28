package com.example.passwordencoder.repo;

import com.example.passwordencoder.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
}
