//package com.gj.controller;
//
//import com.gj.annotation.ApiVersion;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
//* 版本控制验证2
//* @author lich
//*
//*/
//@RestController
//
//@RequestMapping("/{version}/hello")
//public class ApiTest2Controller {
//
//    @RequestMapping("/world")
//    @ResponseBody
//    //注解也可以放在方法上
//    @ApiVersion(3)
//    public String helloWorld3(){
//        System.out.println("版本是3的接口");
//        return "hello,world .version is 3";
//    }
//
//    @RequestMapping("/world")
//    @ResponseBody
//    @ApiVersion(2)
//    public String helloWorld(){
//        System.out.println("版本是2的接口");
//        return "hello,world .version is 2";
//    }
//
//}