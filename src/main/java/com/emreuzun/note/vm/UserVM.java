package com.emreuzun.note.vm;

import com.emreuzun.note.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVM {

    private String id;

    private String username;

    private String name;

    private String surname;

    private String image;

    public UserVM(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
        this.setImage(user.getImage());
    }

}
