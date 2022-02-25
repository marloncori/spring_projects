package pl.tutorial.restapi.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer post_id;

    private String content;

    private String created;

    public Integer getPostId() {
        return post_id;
    }
}
