package com.krishnendu.todonotes.repository;

import java.util.List;
import java.util.Optional;

import com.krishnendu.todonotes.models.Todo;
import com.krishnendu.todonotes.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findByUserAndId(User user, Long id);

    List<Todo> findAllByUser(User user);
}
