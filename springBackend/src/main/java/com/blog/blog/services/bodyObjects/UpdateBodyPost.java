package com.blog.blog.services.bodyObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateBodyPost {
    int id;
    int pin;
    String author;
    String title;
    String text;
}
