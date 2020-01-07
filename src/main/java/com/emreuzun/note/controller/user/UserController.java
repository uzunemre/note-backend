package com.emreuzun.note.controller.user;

import com.emreuzun.note.factory.UserFactory;
import com.emreuzun.note.model.User;
import com.emreuzun.note.request.user.UserSignUpRequest;
import com.emreuzun.note.service.user.UserService;
import com.emreuzun.note.response.GenericResponse;
import com.emreuzun.note.response.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserSignUpRequest request) {
        User user = userService.save(UserFactory.createUser(request));
        int a = 1/0;
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{username}")
    UserResponse getUserByName(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return new UserResponse(user);
    }

}
