package com.tushar007d.secure.notes.service.impl;

import com.tushar007d.secure.notes.com.tushar007d.secure.notes.service.NotesService;
import com.tushar007d.secure.notes.models.Notes;
import com.tushar007d.secure.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private NoteRepository noteRepository;

    public NotesServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @Override
    public Notes createNoteForuser(String username, String content) {
        Notes notes = new Notes();
        notes.setOwnerUsername(username);
        notes.setContent(content);
        return noteRepository.save(notes);
    }

    @Override
    public Notes updateNoteForuser(Long id, String username, String content) {
        return noteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Notes not found with id: "+id)
        );
    }

    @Override
    public void deleteNotesForUser(Long id, String username){
        noteRepository.deleteById(id);
    }

    @Override
    public List<Notes> getNotesForUser(String username){
        return noteRepository.findByOwnerUsername(username);
    }

}
