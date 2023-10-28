package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByMail(student.getMail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("mail taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
       // studentRepository.findById(studentId);
          boolean exists =  studentRepository.existsById(studentId);
          if(!exists){
              throw new IllegalStateException("student with id " + studentId + " doesnt exists");
          }
          studentRepository.deleteById(studentId);
    }
}
