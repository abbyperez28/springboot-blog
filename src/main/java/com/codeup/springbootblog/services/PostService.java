package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;


    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save( Post post ) {
        // Generates a consecutive number
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne( long id ) {
        return posts.get((int) (id - 1));
    }

    private void createPosts() {
        save(new Post("Post 1", "Body 1"));
        save(new Post("Post 2", "Body 2"));
        save(new Post("Post 3", "Body 3"));
    }

    public void update( Post post ) {
        posts.set((int) post.getId() - 1, post);
    }
}


