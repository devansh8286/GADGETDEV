package com.project.Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Frontend.Service.CartService;

@Controller
@RequestMapping("/cart")
public class CartControler {

	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");

		if (result != null) {
			switch (result) {

			case "updated":
				mv.addObject("message", "CartLine has been Updated Sucessfully");
				break;

			case "added":
				mv.addObject("message", "CartLine has been Added Sucessfully");
				break;

			
				
			case "maximum":
				mv.addObject("message", "no more this Product available for You");
				break;


				
				
			case "unavailable":
				mv.addObject("message", "product quantity is not available");
				break;

				
			case "delete":
				mv.addObject("message", "CartLine has been Deleted Sucessfully");
				break;

			case "error":
				mv.addObject("message", "some thig went wrong! ");
				break;

			}
		}

		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLine", cartService.getCartLine());

		return mv;
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String udpateCartLine(@PathVariable int cartLineId, @RequestParam int count) {
		String response = cartService.manageCartLine(cartLineId, count);		
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String updateCart(@PathVariable int cartLineId) {

		String response = cartService.deleteCartLine(cartLineId);

		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {

		String response = cartService.addCartLine(productId);

		return "redirect:/cart/show?" + response;
	}

}
