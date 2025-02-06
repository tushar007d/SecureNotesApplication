package com.tushar007d.secure.notes.com.tushar007d.secure.notes.service;

import com.tushar007d.secure.notes.models.Notes;

import java.util.List;

public interface NotesService {

    Notes createNoteForuser(String username, String content);

    Notes updateNoteForuser(Long id, String username, String content);

    void deleteNotesForUser(Long id, String username);

    List<Notes> getNotesForUser(String username);
}
