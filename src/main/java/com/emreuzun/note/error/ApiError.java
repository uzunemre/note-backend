package com.emreuzun.note.error;

import java.util.Date;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ApiError {

    private long timestamp = new Date().getTime();

    private int status;

    private String message;

    private String url;

    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String url) {
        super();
        this.status = status;
        this.message = message;
        this.url = url;
    }
}
