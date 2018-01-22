package com.codeup.springbootblog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = true)
    private String body;

    public Post() {
    }

    public Post( String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public interface AdsRepository extends CrudRepository<Ad, Long> {

    }
}
