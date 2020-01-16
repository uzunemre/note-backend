package com.emreuzun.note.repository.note;

import com.emreuzun.note.model.note.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, String> {

    Optional<Note> findById(String id);

    List<Note> findByUserId(String userId);

    Optional<Note> findFirstByUserIdOrderByModifiedDateDesc(String userId);

}
