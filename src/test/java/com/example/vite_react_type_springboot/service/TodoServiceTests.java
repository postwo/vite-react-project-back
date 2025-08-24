package com.example.vite_react_type_springboot.service;

import com.example.vite_react_type_springboot.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet()  {

        Long tno =50L;

        log.info(todoService.get(tno));

    }

}