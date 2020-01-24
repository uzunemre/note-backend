package com.emreuzun.note.service.note;

import com.emreuzun.note.error.NotFoundException;
import com.emreuzun.note.model.note.Note;
import com.emreuzun.note.repository.note.NoteRepository;
import com.emreuzun.note.service.user.UserService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private UserService userService;

    public NoteService(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    public Note get(String id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new NotFoundException("Note not found id:" + id);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Note update(String id, String content) {
        Note note = get(id);
        note.setNote(content);
        note.setModifiedDate(LocalDateTime.now());
        noteRepository.save(note);
        return note;
    }

    public void delete(String id) {
        Note note = get(id);
        noteRepository.delete(note);
    }

    public List<Note> findByUserId(String userId) {
        userService.validate(userId);
        return noteRepository.findByUserId(userId);
    }

    public Note findLastModifiedByUserId(String userId) {
        Optional<Note> note = noteRepository.findFirstByUserIdOrderByModifiedDateDesc(userId);
        if (note.isPresent()) {
            return note.get();
        }
        throw new NotFoundException("Last note not found");
    }

}
