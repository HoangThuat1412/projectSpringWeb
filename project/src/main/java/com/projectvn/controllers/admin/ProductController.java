package com.projectvn.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectvn.models.Category;
import com.projectvn.models.Product;
import com.projectvn.services.CategorySercive;
import com.projectvn.services.ProductService;
import com.projectvn.services.StorageService;


@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private CategorySercive categorySercive;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private ProductService productService;
	@RequestMapping("/product")
	public String index(Model model) {
		
		List<Product> listCategory = this.productService.getAll();
		
		model.addAttribute("listCategory", listCategory);
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
	public String save(@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile file) {
		
		//Upload file
		this.storageService.store(file);
		String fileName = file.getOriginalFilename();
		product.setImage(fileName);
		if(this.productService.create(product)) {
			return "redirect:/admin/product";
		}
		return "admin/product/add";
	}
	
	@GetMapping("/product-edit/{id}")
	public String edit(Model model,  @PathVariable("id") Integer id) {
		Product product = this.productService.findById(id);
		model.addAttribute("product", product);
		return "admin/product/edit";
	}
	
	@PostMapping("/product-edit")
	public String update(@ModelAttribute("product") Product product) {
		if(this.productService.create(product)) {
			return "redirect:/admin/product";
		} else {
			return "admin/product-add";
		}
	}
	
	@GetMapping("/product-delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		
		if(this.productService.delete(id)) {
			return "redirect:/admin/product";
		} else {
			return "redirect:/admin/product";
		}
	
	}
}
