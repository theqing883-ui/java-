package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {
    @Insert("insert into tbl_book (name, type, description) values (#{name}, #{type}, #{description})")
    int save(Book book);//返回值影响数据多少行

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    int update(Book book);

    @Delete("delete from tbl_book where  id = #{id}")
    int delete(Integer id);

    @Select("select id, type, name,description from tbl_book where id = #{id}")
    Book getById(int id);

    @Select("select id, type, name,description from tbl_book")
    List<Book> getAll();
}
