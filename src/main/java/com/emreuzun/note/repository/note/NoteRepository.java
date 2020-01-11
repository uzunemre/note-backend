package com.emreuzun.note.repository.note;

import com.emreuzun.note.model.note.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findByUserId(String surveyId);

}
