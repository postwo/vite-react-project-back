package com.example.vite_react_type_springboot.service;

import com.example.vite_react_type_springboot.domain.Todo;
import com.example.vite_react_type_springboot.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
class TodoServiceTests {

    @Autowired
    TodoService todoService;

    // 조회
    @Test
    public void testGet()  {

        Long tno =50L;

        log.info(todoService.get(tno));

    }

    //등록
    @Test
    public void testRegister() {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("title..")
                .content("content..")
                .dueDate(LocalDate.of(2025,12,30))
                .build();

        log.info(todoService.register(todoDTO));

    }

}