package com.codeup.springbootblog;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class PostsController {

//    @GetMapping(path = "/posts")
//    @ResponseBody
//    public String posts(){
//        return "Landing Page!";
//    }

//    @GetMapping(path = "/posts/{id}")
//    @ResponseBody
//    public String postId() {
//        return "This is individual ad page";
//    }

//    @GetMapping(path = "posts/create")
//    @ResponseBody
//    public String showCreateForm() {
//        return "Show form to create a post";
//    }

    @GetMapping(path = "posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a post";
    }


}
