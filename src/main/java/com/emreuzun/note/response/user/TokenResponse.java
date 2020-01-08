package com.emreuzun.note.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenResponse {

    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    private String accessToken;
}
