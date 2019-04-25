package com.project.Frontend.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Backend.DAO.CartLineDAO;
import com.project.Backend.DAO.ProductDAO;
import com.project.Backend.Model.Cart;
import com.project.Backend.Model.CartLine;
import com.project.Backend.Model.Product;
import com.project.Frontend.Model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private ProductDAO productDAO;

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

	public String manageCartLine(int cartLineId, int count) {

		// fetch the cartLine

		CartLine cartLine = cartLineDAO.get(cartLineId);		

		double oldTotal = cartLine.getTotal();

		
		Product product = cartLine.getProduct();
		
		// check if that much quantity is available or not
		if(product.getQuantity() < count) {
			return "result=unavailable";		
		}	
		
		// update the cart line
		cartLine.setProductCount(count);
		cartLine.setBuyingPrice(product.getUnitprice());
		cartLine.setTotal(product.getUnitprice() * count);
		cartLineDAO.update(cartLine);

	
		// update the cart
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
		cartLineDAO.updateCart(cart);
		
		return "result=updated";
	}

	public String deleteCartLine(int cartLineId) {

		// fetch cartLine
		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {

			return "result=error";

		} else {
			Cart cart = this.getCart();

			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());

			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);

			// remove the cart line

			cartLineDAO.delete(cartLine);

			return "result=delete";
		}
	}

	public String addCartLine(int productId) {

		String response = null;

		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);

		if (cartLine == null) {

			// add a new cartLine
			cartLine = new CartLine();

			// fetch the Product
			Product product = productDAO.get(productId);

			cartLine.setCartId(cart.getId());

			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitprice());

			cartLine.setProductCount(1);

			cartLine.setTotal(product.getUnitprice());

			cartLine.setAvailable(true);

			cartLineDAO.add(cartLine);

			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);

			response = "result=added";

		} else {

			// check if the cart line reached maximum count
			if (cartLine.getProductCount() < 5) {
				// updating product for that cartLine
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
			} else {
				response = "result=maximum";
			}

		}

		return response;
	}
}
