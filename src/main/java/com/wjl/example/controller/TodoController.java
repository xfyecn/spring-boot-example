package com.wjl.example.controller;

import com.wjl.example.model.entity.Todo;
import com.wjl.example.service.intf.TodoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: wjl
 * @date: 2021/12/31 15:40
 * @version: v1.0
 */
@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Resource
    private TodoService todoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Todo findById(@RequestParam(name = "id") Long id) {
        return todoService.findTodoById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int add(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

}
