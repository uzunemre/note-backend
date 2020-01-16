package com.emreuzun.note.factory;

import com.emreuzun.note.model.note.Note;
import com.emreuzun.note.request.note.NewNoteRequest;
import java.time.LocalDateTime;

public class NoteFactory {

    public static Note createNote(NewNoteRequest request) {
        return Note.builder()
                .userId(request.getUserId())
                .note(request.getNote())
                .title(request.getTitle())
                .modifiedDate(LocalDateTime.now())
                .build();
    }

}
