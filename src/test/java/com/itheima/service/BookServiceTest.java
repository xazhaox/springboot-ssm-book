package com.itheima.service;

import com.itheima.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName BookServiceTest.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    // 根据id查询
    @Test
    public void selectByIdTest() {
        Book BoolSelectById = bookService.selectById(6);
        System.out.println(BoolSelectById);
    }

    // 查询所有
    @Test
    public void selectAllTest() {
        for (Book book : bookService.selectAll()) {
            System.out.println(book);
        }
    }

    // 根据id修改数据
    @Test
    public void updateByIdTest() {
        Book book = new Book();
        book.setId(13);
        book.setType("计算机理论基础");
        book.setName("C++快速入门");
        book.setDescription("C++30天零基础入门到精通");
        boolean updateById = bookService.updateById(book);
        System.out.println(updateById);
    }

    // 添加数据
    @Test
    public void addTest() {
        Book book = new Book();
        book.setType("四大名著");
        book.setName("红楼梦");
        book.setDescription("C++30天零基础入门到精通");
        boolean add = bookService.add(book);
        System.out.println(add);
    }

    // 删除数据
    @Test
    public void deleteByIdTest(){
        boolean deleteById = bookService.deleteById(18);
        System.out.println(deleteById);
    }
}
