package com.itheima.service;

import com.itheima.pojo.Book;

import java.util.List;

/**
 * @ClassName BookService.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */
public interface BookService {

    // 查询所有
    List<Book> selectAll();

    // 根据id查询
    Book selectById(Integer id);

    // 添加数据
    boolean add(Book book);

    // 根据id修改数据
    boolean updateById(Book book);

    // 根据id删除
    boolean deleteById(Integer id);

}
