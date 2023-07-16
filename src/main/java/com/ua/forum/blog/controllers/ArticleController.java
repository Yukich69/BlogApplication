package com.ua.forum.blog.controllers;

import com.ua.forum.blog.models.Article;
import com.ua.forum.blog.models.User;
import com.ua.forum.blog.repo.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/search-article")
    public String findArticlesByTitle(String title, Model model){
        List<Article> byTitle = articleRepository.findByTitleContaining(title);
        model.addAttribute("foundArticle", byTitle);
        return "search";
    }


    @GetMapping("/article/add/ui")
    public String addArticle(Model model){
        return "addArticle";
    }

    @GetMapping("/add/topic")
    public String addTopic(Model model){
        return "topic1";
    }

    @PostMapping("/article/add")
    public String postArticle(@RequestParam String title, @RequestParam String author, @RequestParam String content, Model model){
        Article article = new Article(title,author,content);
        articleRepository.save(article);
        return "redirect:/articles";
    }


}
