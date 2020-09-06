package io.github.kucingdalamkarung.springjpasample.repository;

import io.github.kucingdalamkarung.springjpasample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.id=?1")
    Optional<User> findById(Integer id);
}
