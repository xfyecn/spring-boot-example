package com.wjl.example.service;

import com.wjl.example.model.entity.Todo;
import com.wjl.example.service.intf.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:58
 * @version: v1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodoServiceTest {

    @Resource
    private TodoService todoService;

    @Test
    public void test() {
        List<Todo> todos = todoService.findAll();
        System.out.println(todos);
    }

    @Test
    public void selectById() {
        Todo todo = todoService.findTodoById(1L);
        System.out.println(todo);
    }

    @Test
    public void add() {
        todoService.addTodo(new Todo(2L, "test3", "rveref", false));
    }

    @Test
    public void update() {
        todoService.updateTodoById(new Todo(3L, "test33", "rveref", false));
    }

    @Test
    public void delete() {
        todoService.deleteTodoById(2L);
    }

}
