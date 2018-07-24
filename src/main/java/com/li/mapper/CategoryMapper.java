package com.li.mapper;


import com.li.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
@Mapper
public interface CategoryMapper {
	@Insert("insert into category(name) values (#{name})")
	void add(Category category);

	@Delete("delete from category where id= #{id}")
	void delete(int id);

	@Select("select * from category where id= #{id}")
	Category get(int id);

	@Update("update category set name=#{name} where id=#{id}")
	void update(Category category);

	@Select("select * from category")
	List<Category> list();

}
