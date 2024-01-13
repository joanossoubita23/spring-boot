package com.blogApp.springbootbasic.controller;

import com.blogApp.springbootbasic.domain.Post;
import com.blogApp.springbootbasic.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("v1/posts")
public class PostController {

    private final PostService postService;

    //Consctructor injection
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public String postPage(Model model) {

        model.addAttribute("posts", postService.getPost());

        return "post";


    }

    @GetMapping("/add")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "addPost";
        }
        postService.addPost(post);
        return "redirect:/v1/posts";
    }
    @GetMapping("/edit/{id}")
    public String ediPost(@PathVariable Integer id, Model model){
        Post post=postService.getPostByid(id);
        model.addAttribute("post",post);
        return "editPost";
    }


@PostMapping("/edit/{id}")
    public String editPost(@PathVariable Integer id, @ModelAttribute("post") @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "editPost";
        }
        postService.updatePostById(id,post);

        return "redirect:/v1/posts";
    }
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Integer id){
        postService.removePostById(id);
        return "redirect:/v1/posts";

    }
}


