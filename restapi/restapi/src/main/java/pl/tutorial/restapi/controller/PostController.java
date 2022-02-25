package pl.tutorial.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.tutorial.restapi.controller.dto.PostDTO;
import pl.tutorial.restapi.controller.mapper.PostDTOMapper;
import pl.tutorial.restapi.error.PostAlreadySavedException;
import pl.tutorial.restapi.error.PostNotFoundException;
import pl.tutorial.restapi.model.Post;
import pl.tutorial.restapi.service.PostService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@EnableSwagger2
@RequiredArgsConstructor
public class PostController {

    private static PostService postService;

    private static PostDTOMapper convert;

    @GetMapping("/posts")
    public List<PostDTO> getPosts(Integer page, Sort.Direction sort) throws PostNotFoundException {
        int pageNumber = page != null && page > 0 ? page : 0;
        Sort.Direction sortDir = sort != null ? sort : Sort.Direction.ASC;
        return convert.mapObjectToPostDTOs(postService.findPosts(pageNumber, sortDir));
    }

    @GetMapping("/posts/comments")
    public List<PostDTO> getPostsWithComment(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return convert.mapObjectToPostDTOs(postService.getPostsWithComments(pageNumber, sortDirection));
    }

    @GetMapping("/posts/{id}")
    public PostDTO getSinglePost(@PathVariable Integer id) throws PostNotFoundException {
        if(id == null) throw new IllegalArgumentException("No identification number has been provided! Please enter a valid POST id.");
        return convert.mapToPostDTO(postService.getSinglePost(id));
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) throws PostAlreadySavedException {
        if(post == null) throw new IllegalArgumentException("No information has been provided! Please enter the POST data.");
        return postService.addPost(post);
    }

    @GetMapping("/posts/{title}")
    public Post getSinglePostByTitle(@PathVariable String title) throws PostNotFoundException {
        if(title.equals("")) throw new IllegalArgumentException("Cannot find post, since no title has been provided!");
        return postService.findPostByTitle(title);
    }

   @PutMapping("/posts")
   public Post updatePost(@RequestBody Post post) throws PostNotFoundException {
       if(post == null) throw new IllegalArgumentException("No information has been provided! Please enter the POST data.");
       return postService.editPost(post);
   }

   @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Integer id)throws PostNotFoundException {
       if(id == null) throw new IllegalArgumentException("No identification number has been provided! Please enter a valid POST id.");
        postService.deletePostById(id);
   }
}
