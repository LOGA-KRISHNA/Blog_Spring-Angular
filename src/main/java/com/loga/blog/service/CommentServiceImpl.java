package com.loga.blog.service;

import com.loga.blog.entity.Comment;
import com.loga.blog.entity.Post;
import com.loga.blog.repo.CommentRepo;
import com.loga.blog.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepository;

    @Autowired
    private PostRepo postRepository;

    public Comment createComment(Long post_id, String postedBy, String content){
        Optional<Post> optionalpost=postRepository.findById(post_id);
        if(optionalpost.isPresent()){
            Comment comment=new Comment();
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());
            comment.setPost(optionalpost.get());
            return commentRepository.save(comment);
        }
        throw new IllegalArgumentException("Post not found");
    }

    public List<Comment> getAllComments(Long postId){
        return commentRepository.findAllByPost_Id(postId);
    }

}
