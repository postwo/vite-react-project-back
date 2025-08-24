package com.example.vite_react_type_springboot.repository.search;

import com.example.vite_react_type_springboot.domain.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1();
}
