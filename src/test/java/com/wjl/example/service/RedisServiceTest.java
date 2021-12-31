package com.wjl.example.service;

import com.wjl.example.model.entity.Todo;
import com.wjl.example.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wjl
 * @date: 2021/12/31 15:57
 * @version: v1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceTest {

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void save() {
        Todo todo = new Todo(1L, "test1", "test111111111111111111", false);
        redisUtil.set("todo:" + todo.getId(), todo);
        System.out.println(redisUtil.get("todo:" + todo.getId()));
        todo.setDetails("test123221122141");
        redisUtil.del("todo:" + todo.getId());
        redisUtil.set("todo:" + todo.getId(), todo);
        System.out.println(redisUtil.get("todo:" + todo.getId()));
    }

    /**
     * test redisService common part
     */
    @Test
    public void commonTest() {
        System.out.println(redisUtil.expire("todo:1", 1000));
        System.out.println(redisUtil.getExpire("todo:1"));
        System.out.println(redisUtil.hasKey("todo:1"));
        System.out.println(redisUtil.hasKey("todo:4"));
        redisUtil.del("todo:1", "todo:4");
        System.out.println(redisUtil.hasKey("todo:1"));
    }

    /**
     * test redisService string part
     */
    @Test
    public void stringTest() {
        redisUtil.set("test:1", "test1111");
        System.out.println(redisUtil.get("test:1"));
        redisUtil.set("test:2", "test2222", 1000);
        System.out.println(redisUtil.getExpire("test:2"));
        redisUtil.set("test1", 1);
        System.out.println(redisUtil.incr("test1", 1));
        redisUtil.set("test2", 100);
        System.out.println(redisUtil.decr("test2", 1));
    }

    /**
     * test redisService map part
     */
    @Test
    public void mapTest() {
        Map<String, Object> map = new HashMap<>();
        map.put(String.valueOf(1L), "aaa");
        map.put(String.valueOf(2L), "bbb");
        map.put(String.valueOf(3L), "ccc");
        System.out.println(redisUtil.hmset("map-test1", map));
        System.out.println(redisUtil.hmset("map-test2", map, 1000));
        System.out.println(redisUtil.hmget("map-test1"));
        System.out.println(redisUtil.hmget("map-test2"));
        System.out.println(redisUtil.hget("map-test1", String.valueOf(1L)));
        System.out.println(redisUtil.hset("map-test1", "4", "ddd"));
        System.out.println(redisUtil.hset("map-test3", "4", "ddd", 30));
        redisUtil.hdel("map-test2", "1", "2");
        System.out.println(redisUtil.hHasKey("map-test2", "2"));
        System.out.println(redisUtil.hHasKey("map-test2", "3"));
        System.out.println(redisUtil.hincr("maptest1", "123", 1));
        System.out.println(redisUtil.hdecr("maptest2", "231", 2));
    }

    /**
     * test redisService set part
     */
    @Test
    public void setTest() {
        System.out.println(redisUtil.sSet("set-test1", "set1", "set2", "set3", "set4"));
        System.out.println(redisUtil.sGet("set-test1"));
        System.out.println(redisUtil.sSetAndTime("set-test2", 100, "set1", "set2"));
        System.out.println(redisUtil.sGetSetSize("set-test1"));
        System.out.println(redisUtil.setRemove("set-test1", "set3"));
        System.out.println(redisUtil.sGetSetSize("set-test1"));
        System.out.println(redisUtil.sHashKey("set-test1", "set2"));
    }

    /**
     * test redisService list part
     */
    @Test
    public void listTest() {
        List<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("ccc");
        System.out.println(redisUtil.lSet("list-test1", "aaaa"));
        System.out.println(redisUtil.lSet("list-test3", "aaaa", 10));
        System.out.println(redisUtil.lSet("list-test2", list));
        System.out.println(redisUtil.lSet("list-test3", list, 100));
        System.out.println(redisUtil.lGet("list-test2", 2, 4));
        System.out.println(redisUtil.lGetListSize("list-test2"));
        System.out.println(redisUtil.lGetIndex("list-test2", 2));
        System.out.println(redisUtil.lUpdateIndex("list-test2", 2, "123"));
        System.out.println(redisUtil.lGetListSize("list-test1"));
        System.out.println(redisUtil.lRemove("list-test1", 4, "aaaa"));
        System.out.println(redisUtil.lGetListSize("list-test1"));
    }

}
