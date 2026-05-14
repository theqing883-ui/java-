package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/users")
public class UserController {

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save(@RequestBody User user) {
        // 在控制台打印接收到的参数值，用于调试
        System.out.println("post新增/保存数据 " + user);
        return "success";
    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id) {
        // 打印 User 对象（toString 方法）
        System.out.println("get查询数据 " + id);
        return "success";
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody User user) {
        // 遍历数组并打印每个元素
        System.out.println("put修改/更新数据" + user);
        return "success";
    }

//    @RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping
    public String delete() {
        // 直接打印列表内容
        System.out.println("delete删除数据");
        return "success";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        // 直接打印列表内容
        System.out.println("delete删除数据" + id);
        return "success";
    }
}