package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(description = "User控制器")
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "姓名", required = true)}
            )
    @PostMapping("insert")
    public int insert(User user) {

        return iUserService.insert(user);
    }

    @GetMapping("selectById")
    public User selectById(@RequestParam Long id) {

        return iUserService.selectById(id);
    }

    @GetMapping("selectAll")
    public List<User> selectAll() {

        return iUserService.selectAll();
    }

}
