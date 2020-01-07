package com.emreuzun.note.factory;

import com.emreuzun.note.model.User;
import com.emreuzun.note.request.user.UserSignUpRequest;

public class UserFactory {

    public static User createUser(UserSignUpRequest request) {
        return User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .surname(request.getSurname())
                .password(request.getPassword()).build();
    }

}
