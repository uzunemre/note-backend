package com.emreuzun.note.controller.login;

import com.emreuzun.note.model.User;
import com.emreuzun.note.shared.CurrentUser;
import com.emreuzun.note.vm.UserVM;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @PostMapping("/api/1.0/login")
    UserVM handleLogin(@CurrentUser User loggedInUser) {
        return new UserVM(loggedInUser);
    }

}