package com.emreuzun.note.security;

public class SecurityConstant {
    static final String LOGIN_URL = "/api/1.0/login";
    static final String SIGN_UP_URL = "/api/1.0/users";
    static final String SIGNING_KEY = "Note123";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
}
