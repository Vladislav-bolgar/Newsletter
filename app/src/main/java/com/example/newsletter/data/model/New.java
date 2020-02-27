package com.example.newsletter.data.model;

public class New {
    private Integer id;
    private String name;
    private String content;
    private String link;

    public New(Integer id, String name, String content,  String link) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
