package com.example.demo.respository;

import com.example.demo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Override
    List<Note> findAll();

    @Override
    Optional<Note> findById(Long id);

    List<Note> findByStudent_Id(Long id);
}
