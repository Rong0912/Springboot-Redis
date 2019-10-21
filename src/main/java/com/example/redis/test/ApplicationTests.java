package com.example.redis.test;

import com.example.redis.domain.User;
import com.example.redis.util.RedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author EDZ
 * @date 2019/10/16
 */

@RestController
public class ApplicationTests {
    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("/test")
    public String test() throws IOException {
        User user=new User("zzz",12);
        redisUtils.saveString("zhuzhe","zhuzhe123");
        //redisUtils.delete("zhuzhe");
        redisUtils.saveBean("aaa",user);
        String zhuzhe=redisUtils.getString("zhuzhe");
        User aaa=redisUtils.getBean("aaa",User.class);
        System.out.println(aaa);
        return zhuzhe;
    }
}
