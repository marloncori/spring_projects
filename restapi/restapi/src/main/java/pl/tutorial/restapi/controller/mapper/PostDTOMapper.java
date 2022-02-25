package pl.tutorial.restapi.controller.mapper;

import pl.tutorial.restapi.controller.dto.PostDTO;
import pl.tutorial.restapi.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDTOMapper {

    private PostDTOMapper(){
        //"To dobra praktyka, aby nikt nie miaŁ do niego dostępu."
    }

    public static List<PostDTO> mapObjectToPostDTOs(List<Post> posts){
        return posts.stream().map(p -> mapToPostDTO(p)).collect(Collectors.toList());
    }

    public static PostDTO mapToPostDTO(Post post){
        return PostDTO.builder()
                .id(post.getId()).title(post.getTitle())
                .content(post.getContent()).created(post.getCreated()).build();
    }
}
