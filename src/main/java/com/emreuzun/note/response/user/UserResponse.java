package com.emreuzun.note.response.user;

import com.emreuzun.note.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private String id;

    private String username;

    private String name;

    private String surname;

    private String image;

    private String token;

    public UserResponse(User user, String token) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
        this.setImage(user.getImage());
        this.setToken(token);
    }

}
