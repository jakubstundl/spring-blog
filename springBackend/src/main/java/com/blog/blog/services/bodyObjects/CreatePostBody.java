package com.blog.blog.services.bodyObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostBody {
    String title;
    String author;
    String text;
    int pin;
}
