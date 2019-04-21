package com.project.Frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Backend.DAO.CategoryDAO;
import com.project.Backend.DAO.ProductDAO;
import com.project.Backend.Model.Category;
import com.project.Backend.Model.Product;
import com.project.Frontend.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
	
		logger.info("inside PageController -INFO");

		logger.debug("inside PageController -Debug");
	
		// passing list of category
		mv.addObject("categories", categoryDAO.CList());

		mv.addObject("userClickHome", "true");
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", "true");
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", "true");
		return mv;
	}

	/*
	 * to load all the product and based on category
	 * 
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Product");

		// passing list of Product

		mv.addObject("categories", categoryDAO.CList());
		mv.addObject("userClickAllProducts", "true");
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		// Category DAO to fetch single Category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.CList());
		// passing single Category Object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", "true");
		return mv;
	}

	

	//For viewing a single Product
	@RequestMapping(value="/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv=new ModelAndView("page");
		Product product=productDAO.get(id);
		if(product == null) throw new ProductNotFoundException(); 
		//update the view Count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
//		----------------------------------
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		return mv;
	}

	
//	Login
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error",required=false) String error) {
		ModelAndView mv = new ModelAndView("login");
		if(error!=null) {
			mv.addObject("messege", "Inavalid User name And  password");
		}
		
		
		mv.addObject("title", "Login");
		return mv;
	}

	
	//access-denied page
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Access-Denied");
		mv.addObject("errorTitle", "Aha! caughyt you Go back :( ");
		mv.addObject("errorDescription", "You are not AUTHORIZE to view THIS PAGE ");
		return mv;
	}



}





