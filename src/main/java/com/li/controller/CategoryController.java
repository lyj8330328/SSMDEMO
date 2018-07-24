package com.li.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.li.pojo.Category;
import com.li.service.CategoryService;


@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		PageHelper.startPage(start, size, "id desc");
		List<Category> categories = categoryService.list();
		PageInfo<Category> pageInfo = new PageInfo<>(categories);
		model.addAttribute("pageInfo", pageInfo);
		// categoryService.addTwo();
		return "listCategory";
	}

	/**
	 * 保存一条记录
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	// @PutMapping("/category")
	public String saveCategory(Category category) {
		categoryService.add(category);
		return "redirect:/category";
	}

	/**
	 * 删除一条记录
	 * 
	 * @param category
	 * @return
	 */
	// @DeleteMapping("/category/{id}")
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public String deleteCategory(Category category) {
		categoryService.delete(category.getId());
		return "redirect:/category";
	}

	/**
	 * 更新一条记录
	 * 
	 * @param category
	 * @param start
	 * @return
	 */
	// @PostMapping("/category/{id}")
	@RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
	public String updateCategory(Category category, int start) {
		categoryService.update(category);
		return "redirect:/category?start=" + start;
	}

	/**
	 * 跳转到编辑页
	 * 
	 * @param model
	 * @param id
	 * @param start
	 * @return
	 */
	// @GetMapping("/category/{id}")
	@RequestMapping(value = "/category/{start}/{id}", method = RequestMethod.GET)
	public String editCategory(Model model, @PathVariable("id") int id, @PathVariable("start") int start) {
		Category category = categoryService.get(id);
		model.addAttribute("category", category);
		model.addAttribute("start", start);
		return "editCategory";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}

}
