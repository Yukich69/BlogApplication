package com.ua.forum.blog.controllers;

import com.ua.forum.blog.models.Article;
import com.ua.forum.blog.models.Comment;
import com.ua.forum.blog.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/discussion/ui/admin")
    public String addComent(Model model){
        return "discussion1";
    }

    @PostMapping("/discussion1")
    public String addComentsTitle(@RequestParam String content, Model model){
        Comment comment = new Comment(content);
        commentRepository.save(comment);
        return "redirect:/discussion1";
    }
}
