package com.codeup.springbootblog.dao;

import com.codeup.springbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository <Post, Long>{
}
