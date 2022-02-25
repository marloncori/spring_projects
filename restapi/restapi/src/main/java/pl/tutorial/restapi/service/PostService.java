package pl.tutorial.restapi.service;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tutorial.restapi.error.PostAlreadySavedException;
import pl.tutorial.restapi.error.PostNotFoundException;
import pl.tutorial.restapi.model.Comment;
import pl.tutorial.restapi.model.ErrorMessage;
import pl.tutorial.restapi.model.Post;
import pl.tutorial.restapi.repository.CommentRepository;
import pl.tutorial.restapi.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;

    @Autowired
    private static ErrorMessage postError;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Post> findPosts(int page, Sort.Direction sort) throws PostNotFoundException {
        Optional<List<Post>> maybePosts = Optional.of(postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))));
        if(!maybePosts.isPresent()){
            throw new PostNotFoundException(postError.getErrMsg());
        }
        return maybePosts.get();
    }

    @Cacheable(cacheNames = "SinglePost", key = "#id")
    public Post getSinglePost(Integer id) throws PostNotFoundException {
        Optional<Post> foundPost = postRepository.findById(id);
        if(!foundPost.isPresent()){
            throw new PostNotFoundException(postError.getErrMsg());
        }
        return foundPost.get();
    }

    @Cacheable(cacheNames = "PostsWithComments")
    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));
        List<Integer> ids = new ArrayList<>();
        for (Post allPost : allPosts) {
            Integer id = allPost.getId();
            ids.add(id);
        }
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, Integer id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) throws PostAlreadySavedException {
        Post newPost = null;
        if(postRepository.findById(post.getId()) != null){
            throw new PostAlreadySavedException(postError.getError());
        } else {
            if(!post.getTitle().equalsIgnoreCase(newPost.getTitle())){
                newPost.setTitle(post.getTitle());
            }
            if(!post.getContent().equalsIgnoreCase(newPost.getContent())){
                newPost.setContent(post.getContent());
            }
            if (!post.getComments().equals(newPost.getComments())){
                newPost.setComments(post.getComments());
            }
        }
        return postRepository.save(newPost);
    }

    @Transactional
    @CachePut(cacheNames = "SinglePost", key = "#result.id")
    public Post editPost(Post post) throws PostNotFoundException {
        Optional<Post> postEdited = postRepository.findById(post.getId());
        if(!postEdited.isPresent()){
            throw new PostNotFoundException(postError.getErrMsg());
        }
        postEdited.get().setTitle(post.getTitle());
        postEdited.get().setContent(post.getContent());
        return postEdited.get();
    }

    @CacheEvict(cacheNames = "SinglePost")
    public void deletePostById(Integer id) throws PostNotFoundException {
        Optional<Post> oldPost = postRepository.findById(id);
        if(!oldPost.isPresent()){
            throw new PostNotFoundException(postError.getErrMsg());
        }
        postRepository.deleteById(oldPost.get().getId());
    }

    @CacheEvict(cacheNames = "PostsWithComments")
    public void clearPostsWithComments() {
        System.out.println("Not implemented yet.");
    }

    public Post findPostByTitle(String title) throws PostNotFoundException {
        Optional<Post> searchedPost = Optional.ofNullable(postRepository.findByTitle(title));
        if(!searchedPost.isPresent()){
            throw new PostNotFoundException(postError.getErrMsg());
        }
        return searchedPost.get();
    }
}
