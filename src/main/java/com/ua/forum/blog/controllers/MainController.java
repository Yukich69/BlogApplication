package com.ua.forum.blog.controllers;

import com.ua.forum.blog.models.Article;
import com.ua.forum.blog.models.User;
import com.ua.forum.blog.repo.ArticleRepository;
import com.ua.forum.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/search/ui")
    public String articleSearch(Model model) {
        List<Article> a = articleRepository.findAll();
        model.addAttribute("foundArticle", a);
        return "search";
    }



    @GetMapping("/userList/admin")
    public String adminDetails(Model model) {
        List<User> user = userRepository.findAll();
        model.addAttribute("users", user);
        return "admin-list1";
    }



    @GetMapping("/article/{id}")
    public String articleDetails(@PathVariable(value= "id") long id, Model model) {
        if(!articleRepository.existsById(id)){
            return "redirect:/articles";
        }
        Optional<Article> article = articleRepository.findById(id);
        ArrayList<Article> art = new ArrayList<>();
        article.ifPresent(art::add);
        model.addAttribute("article", art);
        return "article-details";
    }

    @PostMapping("/admin-list1")
    public String postArticle(@RequestParam String title, @RequestParam String author, @RequestParam String content, Model model){
        Article article = new Article(title,author,content);
        articleRepository.save(article);
        // articleRepository.
        return "redirect:/articles";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable long id, Model model){
        //Article article = new Article(title,author,content);
        userRepository.deleteById(id);
        return "admin-list1";
    }

}
