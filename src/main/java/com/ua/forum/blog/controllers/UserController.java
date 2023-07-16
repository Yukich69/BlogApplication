package com.ua.forum.blog.controllers;

import com.ua.forum.blog.models.User;
import com.ua.forum.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add/registration/ui")
    public String addArticle(Model model){
        return "registration1";
    }

    @PostMapping("/add/registration")
    public String postUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model){
        User user = new User(username,password,email);
        userRepository.save(user);
        return "redirect:/login1";
    }



    @GetMapping("/login")
    public String addLog(Model model){
    return "login";
    }


}
