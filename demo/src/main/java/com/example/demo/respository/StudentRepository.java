package com.example.demo.respository;


import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    Optional<Student> findById(Long id);

    @Override
    List<Student> findAll();
}
