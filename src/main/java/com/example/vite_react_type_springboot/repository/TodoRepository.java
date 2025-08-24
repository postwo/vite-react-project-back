package com.example.vite_react_type_springboot.repository;

import com.example.vite_react_type_springboot.domain.Todo;
import com.example.vite_react_type_springboot.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
