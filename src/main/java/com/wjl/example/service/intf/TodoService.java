package com.wjl.example.service.intf;

import com.wjl.example.model.entity.Todo;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:39
 * @version: v1.0
 */
public interface TodoService {

    int countTodo();

    List<Todo> findAll();

    Todo findTodoById(Long id);

    int addTodo(Todo todo);

    int updateTodoById(Todo todo);

    int deleteTodoById(Long id);

}
