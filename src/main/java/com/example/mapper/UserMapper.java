package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(User user);

    List<User> selectAll();

    User selectById(Long id);
}
