package com.emreuzun.note.controller.user;

import com.emreuzun.note.factory.UserFactory;
import com.emreuzun.note.model.user.User;
import com.emreuzun.note.request.user.UserSignUpRequest;
import com.emreuzun.note.response.user.UserResponse;
import com.emreuzun.note.security.TokenProvider;
import com.emreuzun.note.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserSignUpRequest request) {
        User user = userService.save(UserFactory.createUser(request));
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new UserResponse(user, token));
    }
}
