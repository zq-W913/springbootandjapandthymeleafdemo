package com.offcn.dao;

import com.offcn.pojo.User;
import org.springframework.data.jpa.mapping.JpaPersistentProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    /*分支提交*/
    public User findByNameIs(String name);
    public User findByNameAndAge(String name,Integer age);
}
