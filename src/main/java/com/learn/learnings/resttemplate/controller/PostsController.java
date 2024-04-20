package com.learn.learnings.resttemplate.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learn.learnings.resttemplate.interceptor.RestTemplateInterceptor;
import com.learn.learnings.resttemplate.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PostsController {

    private final RestTemplate restTemplate;

    PostsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/posts")
    public ResponseEntity<Posts> getPosts(){
        ResponseEntity<Posts> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.GET, null, Posts.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }

    @GetMapping("/allPosts")
    public ResponseEntity<List<Posts>> getAllPosts(){
        ResponseEntity<List<Posts>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Posts>>(){});
        return ResponseEntity.ok(responseEntity.getBody());
    }
}
