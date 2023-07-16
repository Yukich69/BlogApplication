package com.ua.forum.blog.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    private User user_id;

    //public Article(User user_id) {
      //  this.user_id = user_id;
    //}

    private String title, author, content;

    public Long getId() {
        return id;
    }

    public Article() {
    }

    public Article(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

   // public Article( User user_id, String title, String author, String content) {
        //this.user_id = user_id;
        //this.title = title;
        //this.author = author;
        //this.content = content;
    //}

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //public void setUser_id(User user) {
    //}
}
