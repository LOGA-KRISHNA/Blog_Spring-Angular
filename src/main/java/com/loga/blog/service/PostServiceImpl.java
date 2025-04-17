package com.loga.blog.service;

import com.loga.blog.entity.Post;
import com.loga.blog.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    public Post savePost(@RequestBody Post post){
        post.setLikecount(0);
        post.setViewcount(0);
        post.setDate(new Date());
        return postRepo.save(post);
    }
}
