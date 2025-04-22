package com.loga.blog.service;

import com.loga.blog.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    Comment createComment(Long post_id, String postedBy, String content);

    List<Comment> getAllComments(Long postId);
}
