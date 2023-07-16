package com.ua.forum.blog.repo;

import com.ua.forum.blog.models.Article;
import com.ua.forum.blog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
