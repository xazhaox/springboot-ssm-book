package com.itheima.controller;

import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BookController.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @Param
     * @Description TODO 添加数据
     */
    @PostMapping  // 请求路径相当于"/books"
    public R add(@RequestBody Book book) {
        boolean result = bookService.add(book);
        R r = new R();
        // 判断result是否为ture
        if (result) {
            // 为ture, 表示添加成功
            r.setCode(Code.ADD_OK);
            r.setMsg("添加成功");
        } else {
            // 为false, 表示添加成功
            r.setCode(Code.ADD_ERROR);
            r.setMsg("添加失败");
        }
        return r;
    }

    /**
     * @Param
     * @Description TODO 修改数据
     */
    @PutMapping  // 请求路径相当于"/books"
    public R updateById(@RequestBody Book book) {
        boolean result = bookService.updateById(book);
        R r = new R(result ? Code.UPDATE_OK : Code.UPDATE_ERROR, result ? "修改成功" : "修改失败");
        return r;
    }

    /**
     * @Param [id]
     * @Description TODO 删除数据
     */

    @DeleteMapping("/{id}") // 请求路径相当于"/books/id"
    public R deleteById(@PathVariable Integer id) {
        boolean result = bookService.deleteById(id);
        R r = new R(result ? Code.DELETE_OK : Code.DELETE_ERROR, result ? "删除成功" : "删除失败");
        return r;
    }

    /**
     * @Param [id]
     * @Description TODO 根据id查询数据
     */
    @GetMapping("/{id}") // 请求路径相当于"/books/id"
    public R selectById(@PathVariable Integer id) {
        Book bookById = bookService.selectById(id);
        // 若id不存在
        if (bookById == null) {
            R r = new R(Code.SELECT_ERROR, null, "数据不存在, 请添加");
            return r;
        }
        R r = new R(Code.SELECT_OK, bookById, "查询成功");
        return r;
    }

    /**
     * @Param []
     * @Description TODO 查询所有数据
     */
    @GetMapping() // 请求路径相当于"/books"
    public R selectAll() {
        List<Book> bookList = bookService.selectAll();
        R r = new R(Code.SELECT_OK, bookList, "查询成功");
        return r;
    }

}
