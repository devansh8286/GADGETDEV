package com.project.Frontend.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Backend.DAO.CartLineDAO;
import com.project.Backend.Model.Cart;
import com.project.Backend.Model.CartLine;
import com.project.Frontend.Model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession session;

	// return cart of user who has logged in
	private Cart getCart() {

		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	// return the entire Cart line
	public List<CartLine> getCartLine() {
//		Cart cart = this.getCart();
		return cartLineDAO.list(this.getCart().getId());
	}

}
