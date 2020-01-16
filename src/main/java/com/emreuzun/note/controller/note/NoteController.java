package com.emreuzun.note.controller.note;

import com.emreuzun.note.factory.NoteFactory;
import com.emreuzun.note.model.note.Note;
import com.emreuzun.note.request.note.NewNoteRequest;
import com.emreuzun.note.request.note.UpdateNoteRequest;
import com.emreuzun.note.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/1.0")
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@Valid @RequestBody NewNoteRequest request) {
        Note note = noteService.save(NoteFactory.createNote(request));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(note.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<?> updateNote(@PathVariable String id, @Valid @RequestBody UpdateNoteRequest request) {
        noteService.update(id, request.getNote());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{userId}/notes")
    public ResponseEntity<?> getNotesOfUser(@PathVariable String userId) {
        List<Note> notes = noteService.findByUserId(userId);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/users/{userId}/lastNote")
    public ResponseEntity<?> getLastNoteOfUser(@PathVariable String userId) {
        Note note = noteService.findLastModifiedByUserId(userId);
        return ResponseEntity.ok(note);
    }


}
