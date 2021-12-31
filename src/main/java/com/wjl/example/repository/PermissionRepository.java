package com.wjl.example.repository;

import com.wjl.example.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wjl
 * @date: 2021/12/31 15:45
 * @version: v1.0
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findPermissionById(Long id);

}
