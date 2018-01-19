package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
class PostsController {
    private PostService service;

    public PostsController(PostService service) {
        this.service = service;
    }

    @RequestMapping("/posts")
    public String showAllPosts(Model viewModel) {
        List<Post> posts = service.findAll();
        viewModel.addAttribute("posts", posts);
        return "/posts/index";
    }




    @RequestMapping("/posts/{id}")
    public String showIndividualPost( @PathVariable int id, Model viewModel) {
        Post post =  service.findOne(id);
        viewModel.addAttribute("post", post);
        return "/posts/show";
    }


    @RequestMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "view the form for creating a form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "create a new post";
    }
}
