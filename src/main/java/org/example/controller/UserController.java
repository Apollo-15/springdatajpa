package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserRequest;
import org.example.entity.Post;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest.getUser(), userRequest.getPosts());
    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/domain")
    public List<User> getUserByDomain(@RequestParam String domain) {
        return userService.getByEmailDomain(domain);
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getPostsByUserId(@PathVariable int userId) {
        return userService.getAllPostsByUsersId(userId);
    }
}
