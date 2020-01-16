package com.emreuzun.note.request.note;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateNoteRequest {

    @NotNull
    private String note;

}
