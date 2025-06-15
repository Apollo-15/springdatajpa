package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from users AS s", nativeQuery = true)
    List<User> getUsers();

    List<User> findByName(String name);

    List<User> findByEmailEndingWith(String emailDomain);

    String name(String name);
}
