package com.learn.learnings.resttemplate.controller;

import com.learn.learnings.resttemplate.model.Posts;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
//        ResponseEntity<Posts> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.GET, null, Posts.class);
        Posts post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", Posts.class);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/allPosts")
    public ResponseEntity<List<Posts>> getAllPosts(){
        ResponseEntity<List<Posts>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        HttpStatusCode statusCode = responseEntity.getStatusCode();
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println("");
        return ResponseEntity.ok(responseEntity.getBody());
    }
}
