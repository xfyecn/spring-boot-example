package com.wjl.example.repository;

import com.wjl.example.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wjl
 * @date: 2021/12/31 15:46
 * @version: v1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long id);

}
