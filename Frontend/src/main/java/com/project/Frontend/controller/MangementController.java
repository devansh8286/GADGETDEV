package com.project.Frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.Backend.DAO.CategoryDAO;
import com.project.Backend.DAO.ProductDAO;
import com.project.Backend.Model.Category;
import com.project.Backend.Model.Product;
import com.project.Frontend.Util.FileUplodeUtility;
import com.project.Frontend.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class MangementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(MangementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nproduct = new Product();
		// set few of The Fields
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		mv.addObject("product", nproduct);

		if (operation != null) {

			if (operation.equals("product")) {
				mv.addObject("messege", "Product Display Sucessfully");
			}
			else if(operation.equals("product")){
				//for handel category
				mv.addObject("messege", "Category submitted Display Sucessfully");
			}

		}

		return mv;
	}

	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		//fetch the product from database
		Product nproduct = productDAO.get(id);
		//set the Product featch from database
		mv.addObject("product",nproduct);
		
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	// handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	
	// bindingresult is come before Model
	
	public String handelProductSubmission(@Valid @ModelAttribute("product") Product mproduct, BindingResult result,
			Model model,HttpServletRequest request) {

		
		
		// check if there are any error
		if(mproduct.getId()==0) {

			//validating for image	
			new ProductValidator().validate(mproduct, result);

		}else {
			if(!mproduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mproduct, result);
			}
		}
		if (result.hasErrors()) {

			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("message","validation Faild!!!!");	
			
			//we can't use redirect because the cannot display error
			return "page";
		}

		logger.info(mproduct.toString());

		if(mproduct.getId() == 0) {
		// create new product Record if id is equal to 0
		productDAO.add(mproduct);
		}
		else {
			
			// update product if id not zero
			productDAO.update(mproduct);
		}

		if(!mproduct.getFile().getOriginalFilename().equals("")) {
			FileUplodeUtility.UploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		
		
		
		
		return "redirect:/manage/products?operation=product";
	}

	
	
	
	
	
	
	
	
	//adding for activating and deactivating the admin product 
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handelProductActivation(@PathVariable int id)
	{
		//goging fatch product data from dataBase
		Product product=productDAO.get(id);
		boolean isActive=product.isActive();
		//activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
	//updating product
		productDAO.update(product);
		return (isActive)? "you have successfully decativating the Product with id :- "+product.getId():
			"you have successfully ativating the Product with id :- "+ product.getId();
		
	}
	
	
	
	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getcategories() {
		return categoryDAO.CList();

	}
	
	//to handle category submission
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handelCategorySubmission(@ModelAttribute Category category){
		categoryDAO.add(category);
		return "redirect:/manage/products/?opration=category";
	}

	//for update category
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
}
