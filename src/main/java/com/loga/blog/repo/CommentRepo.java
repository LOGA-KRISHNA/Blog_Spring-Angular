package com.loga.blog.repo;

import com.loga.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPost_Id(Long post_id);
}
