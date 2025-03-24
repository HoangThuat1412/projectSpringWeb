package com.projectvn.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projectvn.models.Category;
import com.projectvn.models.Product;
import com.projectvn.services.CategorySercive;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private CategorySercive categorySercive;
	@RequestMapping("/product")
	public String index() {
		
		return "admin/product/index";
	}
	
	@RequestMapping("/product-add")
	public String add(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		
		List<Category> listCate = this.categorySercive.getAll();
		model.addAttribute("listCate", listCate);
		
		
		return "admin/product/add";
	}
	
	@PostMapping("/product-add")
	public String save(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
		
		return "redirect:/admin/product";
	}
}
