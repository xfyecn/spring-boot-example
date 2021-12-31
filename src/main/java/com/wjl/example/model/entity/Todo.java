package com.wjl.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: wjl
 * @date: 2021/12/31 15:38
 * @version: v1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {

    private Long id;

    private String description;

    private String details;

    private boolean done;

}
