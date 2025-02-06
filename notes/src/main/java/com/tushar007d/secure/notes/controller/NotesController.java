package com.tushar007d.secure.notes.controller;

import com.tushar007d.secure.notes.com.tushar007d.secure.notes.service.NotesService;
import com.tushar007d.secure.notes.models.Notes;
import com.tushar007d.secure.notes.service.impl.NotesServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController (NotesService notesService){
        this.notesService = notesService;
    }

    /*
    @AuthenticationPrincipal is the Spring security annotation
    which return the current logged in user through UserDetails
     */
    @PostMapping
    public Notes createNotes(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        return notesService.createNoteForuser(username, content);
    }

    @PutMapping("/{noteId}")
    public Notes updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        return notesService.updateNoteForuser(noteId, userDetails.getUsername(), content);
    }

    @GetMapping
    public List<Notes> getUserNotes(@AuthenticationPrincipal UserDetails userDetails){
        return notesService.getNotesForUser(userDetails.getUsername());
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails){
        notesService.deleteNotesForUser(noteId, userDetails.getUsername());
    }

}
