package com.blog.blog.controllers;

import com.blog.blog.entity.Post;
import com.blog.blog.services.bodyObjects.CreatePostBody;
import com.blog.blog.services.bodyObjects.DeletePostBody;
import com.blog.blog.services.PostServices;
import com.blog.blog.services.bodyObjects.UpdateBodyPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    PostServices postServices;
    @Autowired
    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/posts")
    public List<Post> getAllPosts() {
        return postServices.getAll();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/post")
    public Post createPost(@RequestBody CreatePostBody postByUser) {
        return postServices.createPost(
                postByUser.getTitle(),
                postByUser.getAuthor(),
                postByUser.getText(),
                postByUser.getPin());
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/post")
    public ResponseEntity<String> deletePost(@RequestBody DeletePostBody postByUser) {
        int id = postByUser.getId();
        int pin = postByUser.getPin();
        if (postServices.deletePost(id, pin)) {
            return ResponseEntity.status(200).body("{\"message\":\"Post has been deleted.\"}");
        } else {
            return ResponseEntity.status(403).body("{\"message\":\"Provided pin is incorrect.\"}");
        }
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/post")
    public ResponseEntity<Object> updatePost(@RequestBody UpdateBodyPost postByUser) {
       Post updatedPost =  postServices.updatePost(postByUser);
        if (updatedPost!=null) {
            return ResponseEntity.status(200).body(updatedPost);
        } else {
            return ResponseEntity.status(403).body("{\"message\":\"Provided pin is incorrect.\"}");
        }
    }
}
