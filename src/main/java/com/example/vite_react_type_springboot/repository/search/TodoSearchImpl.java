package com.example.vite_react_type_springboot.repository.search;

import com.example.vite_react_type_springboot.domain.QTodo;
import com.example.vite_react_type_springboot.domain.Todo;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch{

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1() {

        log.info("search1.....");

        // 쿼리를 날리기 위한 객체
        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        // 특정 글자가 있는지
        query.where(todo.title.contains("1"));

        // 페이징 처리 : 1페이지 10개를 가지고 와서 tno 기준으로 내림차순
        Pageable pageable = PageRequest.of(1, 10, Sort.by("tno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        //쿼리 실행 ,fetch는 목록 데이터를 가지고 온다
        query.fetch();

        // fetchCount는 long 타입으로 나온다
        query.fetchCount();

        return null;
    }
}
