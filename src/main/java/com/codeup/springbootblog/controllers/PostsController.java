package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.dao.PostDao;
import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {

//    <<<HOW TO CREATE A CONSTRUCTOR INJECTION>>
//    1. create an instance variable with your dependency
    private final PostService postService;

    private PostDao postDao;

    @Autowired
    public PostsController( PostService postService, PostDao postDao ) {
        this.postService = postService;
        this.postDao = postDao;
    }


//    2. Inject the dependency through the constructor and assign it to your instance variable
//    @Autowired
//    public PostsController(PostService postService ) {
//        this.postService = postService;  //This is the first time we assign something to postService
//    }


    @RequestMapping("/posts")
    public String index(Model viewAndModel) {

//        List<Post> posts = postService.findAll();
        Iterable<Post> posts = postService.findAll();
        viewAndModel.addAttribute("posts", posts);
        return "/posts/index";
    }


    @RequestMapping("/posts/{id}")
    public String showIndividualPost( @PathVariable long id, Model viewModel) {
        Post post =  postService.findOne(id);

        viewModel.addAttribute("post", post);

        return "/posts/show";
    }


    @RequestMapping("/posts/new")
    public String showCreatePostForm(Model viewModel) {
        Post post = new Post();
        viewModel.addAttribute("post", post);

        return "/posts/new";
    }

    @PostMapping("/posts/create")
//    ---Model Attribute brings all of the items of the object-----
    public String save(@ModelAttribute Post post) {
    postService.save(post);
    return post.getTitle();
    }

//    -----Edit-----
    @GetMapping("posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewAndModel) {
        Post post = postService.findOne(id);
        viewAndModel.addAttribute("post", post);
        return "posts/edit";
    }

////    -----Redirect-----
//    @PostMapping("/posts/edit")
//    public String updatePost(@ModelAttribute Post post){
//    postService.update(post);
//    return "redirect:/posts";
//    }

//    ----Edit----
    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        post.setId(id);
        postService.save(post);
        return "redirect:/posts";
    }

//    -----Delete-----
    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
