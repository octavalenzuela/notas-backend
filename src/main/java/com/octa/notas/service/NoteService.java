package com.octa.notas.service;
import com.octa.notas.model.Note;
import com.octa.notas.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note nota){
        return noteRepository.save(nota);
    }

    public Optional<Note> getNoteById(long id) {
        return noteRepository.findById(id);
    }

    public Optional<Note> updateNote(long id, Note noteData){
        return noteRepository.findById(id).map(note ->{
            note.setTitulo(noteData.getTitulo());
            note.setDescripcion(noteData.getDescripcion());
            note.setImportancia(noteData.getImportancia());
            return noteRepository.save(note);
        });
    }

    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }
}

