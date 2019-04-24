package com.project.Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.Frontend.Service.CartService;

@Controller
@RequestMapping("/cart")
public class CartControler {

	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLine", cartService.getCartLine());

		return mv;
	}
}
