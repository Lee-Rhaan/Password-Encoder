package com.example.passwordencoder.service;

import com.example.passwordencoder.exception.StudentNotFoundException;
import com.example.passwordencoder.model.Student;
import com.example.passwordencoder.repo.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder)
    {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Student> findAllStudents()
    {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student)
    {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id)
    {
        return studentRepository.findStudentById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with id: " + id + " not found"));
    }

    @Transactional
    public void deleteStudentById(Long id)
    {
        studentRepository.deleteStudentById(id);
    }
}
