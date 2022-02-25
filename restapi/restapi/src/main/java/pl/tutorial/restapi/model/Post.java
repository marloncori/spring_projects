package pl.tutorial.restapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private String created;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id", updatable = false)
    private List<Comment> comments;

    public void setComment(List<Comment> extractComments) {
        this.comments = extractComments;
    }

    public boolean hasComment(){
        if(comments.isEmpty()){
            return false;
        }
        return true;
    }
}
