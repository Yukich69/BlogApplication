package com.ua.forum.blog.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String variables;

    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.REMOVE)
    private List<Article> articleList;
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.REMOVE)
    private List<Discussion> discussionListList;
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.REMOVE)
    private List<Comment> commentListList;





    public User(){
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
