package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface IUserService {

    String getToken(String appId);

    List<User> selectAll();

    User selectById(Long id);

    int insert(User user);

}
