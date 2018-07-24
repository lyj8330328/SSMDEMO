package com.li.service.impl;

import java.util.List;

import com.li.mapper.CategoryMapper;
import com.li.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.li.pojo.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryMapper.list();
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.add(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.update(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryMapper.delete(id);
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void addTwo() {
		// TODO Auto-generated method stub
		Category c1 = new Category();
		c1.setName("短的名字");
		categoryMapper.add(c1);

		Category c2 = new Category();
		c2.setName("放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下放不下");
		categoryMapper.add(c2);
	}

}
