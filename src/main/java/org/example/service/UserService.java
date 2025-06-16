package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.Post;
import org.example.entity.User;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createUser(User user, List<Post> posts) {
        userRepository.save(user);

        // if (true) throw new RuntimeException("Rollback test");

        for (Post post : posts) {
            post.setUser(user);
            postRepository.save(post);
        }
    }

    public List<User> getByName(String name){
        return userRepository.findByName(name);
    }

    public List<User> getByEmailDomain(String domain){
        return userRepository.findByEmailEndingWith(domain);
    }

    public List<Post> getAllPostsByUsersId(int userId){
        return postRepository.findByUserId(userId);
    }
}
