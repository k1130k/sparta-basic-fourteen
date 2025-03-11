package com.example.basicfilter.todo.repository;

import com.example.basicfilter.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
