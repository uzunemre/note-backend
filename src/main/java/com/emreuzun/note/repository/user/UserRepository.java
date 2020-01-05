package com.emreuzun.note.repository.user;

import com.emreuzun.note.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}