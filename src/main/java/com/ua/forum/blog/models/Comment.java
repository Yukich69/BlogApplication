package com.ua.forum.blog.models;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String content;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user_id;

    public Comment(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comment(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //public User getUser_id() {
        //return user_id;
    //}

    //public void setUser_id(User user_id) {
        //this.user_id = user_id;
    //}

    public Comment() {
    }
}
