package com.example.Fakebook.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Posts")
@Table
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private LocalDate date;
    private long userId;
    public PostModel() { this.date = LocalDate.now(); }

    public PostModel(long userid, String content) {
        this.content = content;
        this.userId = userid;
        this.date = LocalDate.now();
        
    }

    public PostModel(long id, String content, LocalDate date) {
        this.id = id;
        this.content = content;
        this.date = LocalDate.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
