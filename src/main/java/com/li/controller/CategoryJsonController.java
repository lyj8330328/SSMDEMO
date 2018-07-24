package com.li.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import com.li.pojo.Category;
import com.li.service.CategoryService;

import java.util.List;

@Controller
public class CategoryJsonController {

	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:" + category);
		categoryService.add(category);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/getOneCategory/{id}")
	public String getOneCategory(@PathVariable("id") int id) {
		Category c = categoryService.get(id);
		JSONObject json = new JSONObject();
		json.put("category", JSONObject.toJSON(c));
		return json.toJSONString();
	}

	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs = categoryService.list();
		return JSONObject.toJSON(cs).toString();
	}
}
