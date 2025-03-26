package com.projectvn.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectvn.models.Category;
import com.projectvn.services.CategorySercive;


@Controller

@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	private CategorySercive categorySercive;
	@GetMapping("/category")
	public String index(Model model, @RequestParam(value = "keyword", required = false ,defaultValue = "") String keyword ,@RequestParam(name="pageNo", defaultValue = "1") Integer pageNo) {
		
		Page<Category> list = this.categorySercive.getAll(pageNo);
		
		if(keyword != null) {
			list = this.categorySercive.searchCategory(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("list",list);
		return "admin/category/index";
	}
	
	@GetMapping("/add-category")	
	public String add(Model model) {
		
		Category category = new Category();
		category.setCategoryStatus(true);
		model.addAttribute("category", category);
		return "admin/category/add";
	}
	@PostMapping("/add-category")
	
	public String save(@ModelAttribute("category") Category category) {
		
		if(this.categorySercive.create(category)) {
			return "redirect:/admin/category";			
		} else {
			return "admin/category/add";
		}
	}
	
	@GetMapping("/edit-category/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		
		Category category = this.categorySercive.findById(id);
		model.addAttribute("category", category);
		return "admin/category/edit";
	}
	@PostMapping("/edit-category")
	public String update(@ModelAttribute("category") Category category) {
		
		if(this.categorySercive.create(category)) {
			return "redirect:/admin/category";			
		} else {
			return "admin/category/add";
		}
	}
	@GetMapping("/delete-category/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		if(this.categorySercive.delete(id)) {
			return "redirect:/admin/category";			
		} else {
			return "redirect:/admin/category";
		}
	}
}
