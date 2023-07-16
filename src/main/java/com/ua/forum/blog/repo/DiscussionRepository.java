package com.ua.forum.blog.repo;

import com.ua.forum.blog.models.Article;
import com.ua.forum.blog.models.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
}
