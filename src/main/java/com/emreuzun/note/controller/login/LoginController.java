package com.emreuzun.note.controller.login;

import com.emreuzun.note.model.User;
import com.emreuzun.note.request.user.UserLoginRequest;
import com.emreuzun.note.response.user.TokenResponse;
import com.emreuzun.note.response.user.UserResponse;
import com.emreuzun.note.security.TokenProvider;
import com.emreuzun.note.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/1.0")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequest request) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<?> login(@AuthenticationPrincipal UserDetails userDetail) throws AuthenticationException {
        final User user = userService.getByUsername(userDetail.getUsername());
        return ResponseEntity.ok(new UserResponse(user));
    }




}
