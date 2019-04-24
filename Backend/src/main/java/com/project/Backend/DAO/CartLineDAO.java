package com.project.Backend.DAO;

import java.util.List;

import com.project.Backend.Model.Cart;
import com.project.Backend.Model.CartLine;

public interface CartLineDAO {

	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int ProductId);
	boolean updateCart(Cart cart);

	
}
