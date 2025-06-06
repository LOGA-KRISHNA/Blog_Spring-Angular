package com.loga.blog.controller;

import com.loga.blog.entity.Post;
import com.loga.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")

public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        try{
            Post createPost=postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createPost);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable long id){
        try{
            Post post=postService.getPostById(id);
            post.setViewcount(post.getViewcount()+1);
            post.setLikecount(post.getLikecount()+1);
            return ResponseEntity.ok(post);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likepost(@PathVariable Long postId){
        try{
            postService.likepost(postId);
            return ResponseEntity.ok(new String[]{"Post Liked Successfully"});
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getLocalizedMessage());
        }
    }
}
