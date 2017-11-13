/**
 * 
 */
package com.indiaugury.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.indiaugury.shoppingbackend.dao.CategoryDAO;
import com.indiaugury.shoppingbackend.dto.Category;

/**
 * @author sanchitp
 *
 */
@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		// Passing the autowired object
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", "true");
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", "true");
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", "true");
		return mv;
	}
	
	
	/*
	 * Methods to load All product based on category
	 */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		// Passing the autowired object
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", "true");
		return mv;
	}
	
	/*
	 * Methods to load All product based on category
	 */
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//category DAO to fect single category
		
		Category category= null;
		category=categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		// Passing the autowired object
		mv.addObject("categories", categoryDAO.list());
		
		//Passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", "true");
		return mv;
	}
	

	// @RequestMapping(value="/test")
	// public ModelAndView test(@RequestParam(value="greeting" ,
	// required=false)String greeting){
	// if(greeting==null){
	// greeting="Hello You Missed";
	// }
	//
	// ModelAndView mv= new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }

	// @RequestMapping(value="/test/{greeting}")
	// public ModelAndView test(@PathVariable("greeting")String greeting){
	// if(greeting==null){
	// greeting="Hello You Missed";
	// }
	//
	// ModelAndView mv= new ModelAndView("page");
	// mv.addObject("greeting",greeting);
	// return mv;
	// }

}
