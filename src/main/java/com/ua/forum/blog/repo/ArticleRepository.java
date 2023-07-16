package com.ua.forum.blog.repo;

import com.ua.forum.blog.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {


//    @Query("select s from Article s where s.title like '%?1%'" )
    List<Article> findByTitleContaining(String title);
    //List<Article> findByName(String title);
}
