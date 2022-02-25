package pl.tutorial.restapi.controller.dto;

import lombok.*;

@Builder
@Getter
public class PostDTO {

    @NonNull
    private Integer id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    private String created;
}
