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
public class Hello {

    @GetMapping("/hello")
    //@ApiVersion(1)
    public String hello0(){
        return "hello 0";
    }

    @GetMapping("/hello")
    @ApiVersion(value = "1.0.1")
    public String hello(String name){
        return name +": hello 1";
    }

    @GetMapping("/hello")
    @ApiVersion(value = "1.0.4")
    public String hello3(String name){
        return name +": hello 4";
    }


    @GetMapping("/hello")
    @ApiVersion(value = "1.0.2")
    public String hello2(String name,Integer age){
        return "hello 2 :"+name+","+age;
    }

    @PostMapping("/hello")
    @ApiVersion(value = "1.0.3")
    public String hello3(@RequestBody User user){

        System.out.println(user);
        return "hello 3";
    }



}
