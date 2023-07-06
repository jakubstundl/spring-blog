package com.blog.blog.services;

import com.blog.blog.entity.Post;
import com.blog.blog.repository.PostRepository;
import com.blog.blog.services.bodyObjects.UpdateBodyPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll();
        posts.forEach(post -> post.setPin(0));
        return posts;
    }

    public Post createPost(String title, String author, String text, int pin) {
        //create post
        Post post = new Post();
        post.setTitle(title);
        post.setAuthor(author);
        post.setText(text);
        post.setPin(pin);
        // save post
        Post savedPost = postRepository.save(post);
        return savedPost;

    }

    public boolean deletePost(int id, int pin) {
        Post postToDelete = postRepository.findById(id).get();
        if (pin == postToDelete.getPin()) {
            postRepository.delete(postToDelete);
            return true;
        } else {
            return false;
        }
    }

    public Post updatePost(UpdateBodyPost postUpdated) {
        Post postToUpdate = postRepository.findById(postUpdated.getId()).get();

        if (postToUpdate.getPin() == postUpdated.getPin()) {
            if (postUpdated.getAuthor() != null) {
                postToUpdate.setAuthor(postUpdated.getAuthor());
            }
            if (postUpdated.getTitle() != null) {
                postToUpdate.setTitle(postUpdated.getTitle());
            }
            if (postUpdated.getText() != null) {
                postToUpdate.setText(postUpdated.getText());
            }

            return postRepository.save(postToUpdate);
        } else {
            return null;
        }
    }


}
