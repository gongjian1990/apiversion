package com.gj.controller;

import com.gj.annotation.ApiVersion;
import com.gj.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * :
 *
 * @author: 赵云
 * @create: 2020-04-02
 * @since 1.0.8
 */
@RestController
@RequestMapping("/hello")
public class HelloV102 {


    @GetMapping("/hello")
    @ApiVersion(value = "1.0.6")
    public String hello(String name){
        return name +": hello 6";
    }

    @GetMapping("/hello")
    @ApiVersion(value = "1.0.7")
    public String hello2(String name,Integer age){
        return "hello 7 :"+name+","+age;
    }

    @PostMapping("/hello")
    @ApiVersion(value = "1.0.8")
    public String hello3(@RequestBody User user){
        System.out.println(user);
        return "hello 8";
    }

}
