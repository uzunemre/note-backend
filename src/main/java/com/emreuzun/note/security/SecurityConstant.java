package com.emreuzun.note.security;

public class SecurityConstant {
    static final String LOGIN_URL = "/api/1.0/login";
    static final String SIGN_UP_URL = "/api/1.0/users";
    static final String SECRET = "EmakinaTalent";
    static final long EXPIRATION_TIME = 432_000_000; // 5 day
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
}
