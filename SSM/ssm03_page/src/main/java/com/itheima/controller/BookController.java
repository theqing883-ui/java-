package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
//        System.out.println(book);
        return new Result((flag ? Code.SAVE_OK : Code.SAVE_ERR), flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
//        System.out.println(book);
        return new Result((flag ? Code.UPDATE_OK : Code.UPDATE_ERR), flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        boolean flag = bookService.delete(id);
//       System.out.println(book);
        return new Result((flag ? Code.DELETE_OK : Code.DELETE_ERR), flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id) {
       /* if(id < 0){
            throw new BusinessException(Code.BUSINESS_EXP,"你输得有问题，重新输入");
        }
        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_EXP,"网络卡顿稍后再试");
        }*/
        if(id == 2){//功能测试
            throw new BusinessException(Code.BUSINESS_EXP,"你输得有问题，重新输入");
        }
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String message = book != null ? "" : "查询失败";
//        System.out.println(bookService.getById(id));
        return new Result(code, book, message);
    }

    @GetMapping
    public Result getAll() {
//        int i = 1/0;
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String message = bookList != null ? "" : "查询失败";
//        System.out.println(bookList);
        return new Result(code, bookList, message);
    }
}
