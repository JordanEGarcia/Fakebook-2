package com.example.Fakebook.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    private long id;
    private String content;
    private LocalDate date;
    private int userId;
    public Post() {}

    public Post(String content) {
        this.content = content;
        this.date = LocalDate.now();
    }

    public Post(long id, String content, LocalDate date) {
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
}
