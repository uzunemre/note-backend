package com.emreuzun.note.security;

import com.emreuzun.note.error.NotFoundException;
import com.emreuzun.note.model.user.User;
import com.emreuzun.note.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collections;

@Service("authUserService")
public class AuthUserService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        User user = userService.getByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
