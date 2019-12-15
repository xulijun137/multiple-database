package com.example;

import com.example.entity.User;
import com.example.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MultiDBApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private IUserService IUserService;

    @Test
    public void testWrite() {
        User user = new User();
        user.setName("zhangsan");
        IUserService.insert(user);
    }

    @Test
    public void testRead() {
        for (int i = 0; i < 4; i++) {
            IUserService.selectAll();
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("wangwu");
        IUserService.insert(user);
    }

    @Test
    public void testReadFromMaster() {
        IUserService.getToken("1234");
    }


}
