package com.octa.notas.controller;

import com.octa.notas.model.Note;
import com.octa.notas.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //esta clase maneja requests HTTP y devuelve
@RequestMapping("/api/notes") //prefijo de todos los endpoints.
@CrossOrigin(origins = "https://ovnotasapp.netlify.app/") // donde corre

public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

   @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
   }

   @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
   }

   @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteData) {
        return noteService.updateNote(id, noteData)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
   }

}
