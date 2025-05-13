package com.loga.blog.controller;

import com.loga.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("comment/create")
    public ResponseEntity<?> createComment(@RequestParam Long post_id, @RequestParam String postedBy, @RequestParam String content ){
        try{
            return ResponseEntity.ok(commentService.createComment(post_id,postedBy,content));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getLocalizedMessage());
        }
    }

    @GetMapping("comment/{postId}")
    public ResponseEntity<?> getAllComments(@PathVariable Long postId){
        try{
            return ResponseEntity.ok(commentService.getAllComments(postId));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getLocalizedMessage());
        }
    }
}
