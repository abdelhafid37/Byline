package ByLine.com.ByLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ByLine.com.ByLine.Service.PostService;
import ByLine.com.ByLine.models.PostDTO;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public List<PostDTO> getAll() {
        return service.getAllPosts();
    }

    @GetMapping("/{slug}")
    public PostDTO getBySlug(@PathVariable String slug) {
        return service.getBySlug(slug);
    }
}