package com.loga.blog.service;

import com.loga.blog.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(long id);

    void likepost(Long postId);
}
