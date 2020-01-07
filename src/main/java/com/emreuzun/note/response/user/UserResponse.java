package com.emreuzun.note.response.user;

import com.emreuzun.note.model.User;
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

    public UserResponse(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
        this.setImage(user.getImage());
    }

}
