package com.itheima.dao;

import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName BookDao.java
 * @Author xazhao
 * @Create 2022.06.25
 * @Description TODO
 */

@Mapper // 告诉springboot创建该接口的代理对象
public interface BookDao {

    // 查询所有  tb_book
    @Select("select * from tb_book")
    List<Book> selectAll();

    // 根据id查询
    @Select("select * from tb_book where id = #{id}")
    Book selectById(Integer id);

    // 添加数据
    @Insert("insert into tb_book (id, type, name, description) values (null, #{type}, #{name}, #{description})")
    int add(Book book);

    // 根据id修改数据
    @Update("update tb_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    int updateById(Book book);

    // 根据id删除
    @Delete("delete from tb_book where id = #{id}")
    int deleteById(Integer id);
}
