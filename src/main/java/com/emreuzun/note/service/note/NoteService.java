package com.emreuzun.note.service.note;

import com.emreuzun.note.model.note.Note;
import com.emreuzun.note.repository.note.NoteRepository;
import com.emreuzun.note.service.user.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private UserService userService;

    public NoteService(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findByUserId(String userId) {
        userService.validate(userId);
        return noteRepository.findByUserId(userId);
    }

}
