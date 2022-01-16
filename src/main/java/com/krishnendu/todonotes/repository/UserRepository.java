package com.krishnendu.todonotes.repository;

import java.util.Optional;

import com.krishnendu.todonotes.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
