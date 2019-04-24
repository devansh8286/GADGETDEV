//package com.project.Backend.CartLine;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.project.Backend.DAO.CartLineDAO;
//import com.project.Backend.DAO.ProductDAO;
//import com.project.Backend.DAO.UserDAO;
//import com.project.Backend.Model.Cart;
//import com.project.Backend.Model.CartLine;
//import com.project.Backend.Model.Product;
//import com.project.Backend.Model.User;
//
//public class TestCartLine {
//
//	private static AnnotationConfigApplicationContext context;
//
//	private static CartLineDAO cartLineDAO;
//	private static ProductDAO productDAO;
//	private static UserDAO userDAO;
//	private User user;
//	private Cart cart;
//	private Product product;
//	private CartLine cartLine = null;
//
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com");
//		context.refresh();
//		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
//		productDAO = (ProductDAO) context.getBean("productDAO");
//		userDAO = (UserDAO) context.getBean("userDAO");
//	}
//	
//	@Test
//	public void addNewCart() {
//		
//		//1.get the user
//		user=userDAO.getByEmail("sg@gmail.com");
//		
//		//2.fetch the cart
//		cart =user.getCart();
//		
//		//3.get the Product
//		product=productDAO.get(3);
//		
//		//4.create new cart Line
//		
//		cartLine=new CartLine();
//		
//		cartLine.setBuyingPrice(product.getUnitprice());
//		
//		cartLine.setProductCount(cartLine.getProductCount() +1);
//		
//		cartLine.setTotal(cartLine.getProductCount() * product.getUnitprice());
//		
//		cartLine.setAvailable(true);
//		
//		cartLine.setCartId(cart.getId());
//		
//		cartLine.setProduct(product);
//		
//		assertEquals("failed to add the CartLine", true,cartLineDAO.add(cartLine));
//		
//		
//		//update cart 
//		
//		
//		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
//		
//		cart.setCartLines(cart.getCartLines()+1);
//		
//		assertEquals("failed to update Cart", true,cartLineDAO.updateCart(cart));
//		
//	}
//	
//	
//	
//}
