package com.wjl.example.repository;

import com.wjl.example.model.entity.Todo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/12/31 15:39
 * @version: v1.0
 */
@Mapper
@Repository
public interface TodoRepository {

    @Select("select count(*) from todo")
    int countTodo();

    @Select("select * from todo")
    List<Todo> findAll();

    @Select("select * from todo where id=#{id}")
    Todo findTodoById(@Param(value = "id") Long id);

    @Insert("insert into todo(id, description, details, done) values (#{id}, #{description}, #{details}, #{done})")
    int addTodo(Todo todo);

    @Update("update todo set description=#{description}, details=#{details}, done=#{done} where id=#{id}")
    int updateTodo(Todo todo);

    @Delete("delete from todo where id=#{id}")
    int deleteTodo(@Param(value = "id") Long id);

}
