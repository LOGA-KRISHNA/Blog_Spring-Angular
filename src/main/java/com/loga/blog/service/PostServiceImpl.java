package com.loga.blog.service;

import com.loga.blog.entity.Post;
import com.loga.blog.repo.PostRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }
    public Post getPostById(long id){
        Optional<Post> optionalpost=postRepo.findById(id);
        if(optionalpost.isPresent()){
            Post post=optionalpost.get();
            post.setLikecount(post.getLikecount()+1);
            return postRepo.save(post);
        }else{
            return null;
        }
    }
}
