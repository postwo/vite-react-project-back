package com.example.vite_react_type_springboot.service;

import com.example.vite_react_type_springboot.domain.Todo;
import com.example.vite_react_type_springboot.dto.TodoDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface TodoService {

    // 검색
    TodoDTO get(Long tno);

    // 등록
    Long register(TodoDTO dto);

    // 수정
    void modify(TodoDTO dto);

    // 삭제
    void remove(Long tno);

    // entity -> dto 로 변환
    default TodoDTO entityToDto(Todo todo) {
        return TodoDTO.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .content(todo.getContent())
                .complete(todo.isComplete())
                .dueDate(todo.getDueDate())
                .build();
    }

    // dto -> entity로 변환
    default Todo dtoToEntity(TodoDTO todoDTO) {
        return Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .complete(todoDTO.isComplete())
                .dueDate(todoDTO.getDueDate())
                .build();
    }
}
