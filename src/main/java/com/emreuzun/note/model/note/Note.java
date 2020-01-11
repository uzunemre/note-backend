package com.emreuzun.note.model.note;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@Document(collection = "user")
public class Note {

    @Id
    private String id;

    @NotNull
    private String userId;

    @NotNull
    private String note;

}
