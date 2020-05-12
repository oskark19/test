package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.request.AddNoteRequest;
import com.example.demo.respository.NoteRepository;
import com.example.demo.respository.StudentRepository;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/findallnotes")
    public ResponseEntity<List<Note>> findAllNotes(){
        List<Note> notes = noteRepository.findAll();
        return ResponseEntity.ok().body(notes);
    }

    @GetMapping("/findnotebystudent/{studentId}")
    public ResponseEntity<List<Note>> findByStudentId(@PathVariable("studentId") Long id){
        return ResponseEntity.ok().body(noteRepository.findByStudent_Id(id));
    }


    @PostMapping("/createnote")
    public ResponseEntity<Note> createNote(@Valid @RequestBody AddNoteRequest addNoteRequest){
        Student student =  studentRepository.findById(addNoteRequest.getStudentId()).orElseThrow(() -> new IllegalArgumentException());
        Note note = new Note(addNoteRequest.getValue(),addNoteRequest.getDescription(), student);
        return ResponseEntity.ok().body(noteRepository.save(note));
    }

}
