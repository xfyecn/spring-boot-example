package com.wjl.example.service.impl;

import com.wjl.example.model.entity.Todo;
import com.wjl.example.repository.TodoRepository;
import com.wjl.example.service.intf.TodoService;
import com.wjl.example.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author: wjl
 * @date: 2021/12/31 15:40
 * @version: v1.0
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "todo")
public class TodoServiceImpl implements TodoService {

    @Resource
    private TodoRepository todoRepository;

    @Resource
    private RedisUtil redisUtil;

    public static final String CACHE_KEY_TODO = "todo:";

    @Override
    public int countTodo() {
        return todoRepository.countTodo();
    }

    @Override
    public List<Todo> findAll() {
        int i = countTodo();
        Object o = redisUtil.get(CACHE_KEY_TODO + "number:" + i);
        if (!Objects.isNull(o)) {
            return (List<Todo>) o;
        }
        List<Todo> todos = todoRepository.findAll();
        redisUtil.set(CACHE_KEY_TODO + "number:" + i, todos);
        log.info("cache not exist, do this method");
        return todos;
    }

    @Override
    public Todo findTodoById(Long id) {
        Object o = redisUtil.get(CACHE_KEY_TODO + id);
        if (!Objects.isNull(o)) {
            log.info("get from redis: {}", o);
            return (Todo) o;
        }
        Todo todo = todoRepository.findTodoById(id);
        redisUtil.set(CACHE_KEY_TODO + id, todo);
        log.info("get from mysql, and set into redis: {}", todo);
        return todo;
    }

    @Override
    public int addTodo(Todo todo) {
        int i = todoRepository.addTodo(todo);
        redisUtil.set(CACHE_KEY_TODO + todo.getId(), todo);
        log.info("write into redis: {}", todo);
        return i;
    }

    @Override
    public int updateTodoById(Todo todo) {
        int i = todoRepository.updateTodo(todo);
        redisUtil.set(CACHE_KEY_TODO + todo.getId(), todo);
        log.info("update data and delete cache");
        return i;
    }

    @Override
    public int deleteTodoById(Long id) {
        int i = todoRepository.deleteTodo(id);
        redisUtil.del(CACHE_KEY_TODO + id);
        return i;
    }

}
