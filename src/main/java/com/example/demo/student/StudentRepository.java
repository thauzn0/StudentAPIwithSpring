package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    //SELECT * FROM student WHERE mail = ?
    @Query("SELECT s FROM Student s WHERE s.mail =?1")
    Optional<Student> findStudentByMail(String mail);

}
