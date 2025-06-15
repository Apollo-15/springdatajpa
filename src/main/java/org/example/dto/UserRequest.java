package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Post;
import org.example.entity.User;

import java.util.List;

@Getter
@Setter
public class UserRequest{
    private User user;
    private List<Post> posts;
}