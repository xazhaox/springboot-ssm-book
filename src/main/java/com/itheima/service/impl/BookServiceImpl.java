package com.itheima.service.impl;

import com.itheima.controller.Code;
import com.itheima.dao.BookDao;
import com.itheima.exception.BusinessException;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookServiceImpl.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    // 查询所有
    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    // 根据id查询
    @Override
    public Book selectById(Integer id) {

        // 模拟义务异常, 包装成自定义异常
        if (id == 1) {
            throw new BusinessException(Code.BUSINESS_ERROR, "服务器路径未知异常");
        }
        //模拟系统异常，将可能出现的异常进行包装，转换成自定义异常
        /*try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERROR, "服务器访问超时，请重试!", e);
        }*/

        return bookDao.selectById(id);
    }

    // 添加数据
    @Override
    public boolean add(Book book) {
        return bookDao.add(book) > 0;
    }

    // 修改数据
    @Override
    public boolean updateById(Book book) {
        return bookDao.updateById(book) > 0;
    }

    // 删除数据
    @Override
    public boolean deleteById(Integer id) {
        return bookDao.deleteById(id) > 0;
    }
}
