package com.codeup.springbootblog.services;

import com.codeup.springbootblog.dao.PostDao;
import com.codeup.springbootblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
//    private List<Post> posts;
    private PostDao postDao;


    public PostService(PostDao postDao) {
//        posts = new ArrayList<>();
//        createPosts();
        this.postDao = postDao;
    }

//    public List<Post> findAll() {
//        return post;
//    }
    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public void save( Post post ) {
        // Generates a consecutive number
//        post.setId(posts.size() + 1);
//        posts.add(post);
//        return post;
        postDao.save(post);
    }

    public Post findOne( long id ) {
//        return posts.get((int) (id - 1));
        return postDao.findOne(id);
    }

    private void createPosts() {
        save(new Post("Post 1", "Body 1"));
        save(new Post("Post 2", "Body 2"));
        save(new Post("Post 3", "Body 3"));
    }

//    public void update( Post post ) {
//        posts.set((int) post.getId() - 1, post);
//    }

    public void delete (long id) {
        postDao.delete(id);
    }

}


