package com.example.vite_react_type_springboot.repository;


import com.example.vite_react_type_springboot.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2 // 원래는 로그 안찍음 지금은 그냥 편하게 하기 위해 사용
class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {

        Assertions.assertNotNull(todoRepository);

        log.info(todoRepository.getClass().getName());

    }

    @Test
    public void testInsert()  {

        Todo todo = Todo.builder()
                .title("title")
                .content("content")
                .dueDate(LocalDate.of(2025,12,30))
                .build();

        Todo result = todoRepository.save(todo);

        log.info(result);

    }

    @Test
    public void testRead()  {

        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }

    @Test
    public void testUpdate() {

        // 먼저 로딩 하고 엔티티 객체를 변경 /setter를 사용

        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        todo.changeTitle("update title");
        todo.changeContent("update content");
        todo.changeComplete(true);

        todoRepository.save(todo);


    }
}