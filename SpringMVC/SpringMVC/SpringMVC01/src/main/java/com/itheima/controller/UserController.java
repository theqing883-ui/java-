package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user) {
        // 在控制台打印接收到的参数值，用于调试
        System.out.println("post更改数据 " + user);
        return "success";
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable("id") Integer id) {
        // 打印 User 对象（toString 方法）
        System.out.println("get查询数据 " + id);
        return "success";
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user) {
        // 遍历数组并打印每个元素
        System.out.println("put新增数据" + user);
        return "success";
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete() {
        // 直接打印列表内容
        System.out.println("delete删除数据");
        return "success";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable("id") Integer id) {
        // 直接打印列表内容
        System.out.println("delete删除数据" + id);
        return "success";
    }











    @RequestMapping("/saveJopo")
    @ResponseBody
    public String saveJopo(@RequestBody User user) {
        // 直接打印列表内容
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/date")
    @ResponseBody
    public String date(@RequestParam("date") Date date) {
        // 直接打印列表内容
        System.out.println(date);
        return "success";
    }
}