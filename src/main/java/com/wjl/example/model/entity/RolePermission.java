package com.wjl.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: wjl
 * @date: 2021/12/31 15:45
 * @version: v1.0
 */
@Getter
@Setter
@Entity
@Table(name = "role_permission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long rid;

    private Long pid;

}
