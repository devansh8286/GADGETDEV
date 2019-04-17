//package com.project.Backend.User;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.project.Backend.DAO.UserDAO;
//import com.project.Backend.Model.Address;
//import com.project.Backend.Model.Cart;
//import com.project.Backend.Model.User;
//
//public class UserTestCase {
//
//	private static AnnotationConfigApplicationContext context;
//	private static UserDAO userDAO;
//	private User user = null;
//	private Cart cart = null;
//	private Address address = null;
//
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com");
//		context.refresh();
//
//		userDAO = (UserDAO) context.getBean("userDAO");
//	}
////	@Test
////	public void testAdd() {
////	  
////	  user = new User();
////	  user.setFirstName("martin"); 
////	  user.setLastName("garix");
////	  user.setEmail("martin@gmail.com");
////	  user.setContactNumber("9998776655");
////	  user.setRole("USER");
////	  user.setPassword("1234");
////	  
////	  // add the user
////	  assertEquals("fail to add User", true,userDAO.addUser(user));
////
////	  address = new Address(); 
////	  address.setAddressLineOne("505");
////	  address.setAddressLineTwo("narmada"); 
////	  address.setCity("mumbai");
////	  address.setState("mh");
////	  address.setCountry("India");
////	  address.setPostalCode("401105");
////	  address.setBilling(true);
////	  
////	  // link user with address using user id 
////	  address.setUserId(user.getId()); 
////	  
////	  //add user address 
////	  assertEquals("fail to add address", true,userDAO.addAddresss(address));
////	  
////	  if (user.getRole().equals("USER")) 
////	  { 
////		  //cart for user
////		  cart = new Cart();
////		  
////		  cart.setUser(user);
////		  
////		  //add the cart
////		  assertEquals("fail to add cart", true,userDAO.add(cart));
////
////		  
////		  address = new Address(); 
////		  address.setAddressLineOne("503");
////		  address.setAddressLineTwo("armadanagar"); 
////		  address.setCity("thane");
////		  address.setState("mh"); 
////		  address.setCountry("India");
////		  address.setPostalCode("401105");
////		  // set shipping to true
////		  address.setShipping(true);
////		  
////		  // link it with user 
////		  address.setUserId(user.getId());
////		  
////		  // add user Cart 
////		  assertEquals("fail to add shipping Address", true,userDAO.addAddresss(address));
////		  
////		 
////	  }
////		  
////	  
////	  }
//
////	@Test
////	public void testAdd() {
////
////		user = new User();
////		user.setFirstName("martin");
////		user.setLastName("garix");
////		user.setEmail("martin@gmail.com");
////		user.setContactNumber("9998776655");
////		user.setRole("USER");
////		user.setPassword("1234");
////
////		
////		if (user.getRole().equals("USER")) {
////			// cart for user
////			cart = new Cart();
////
////			cart.setUser(user);
////
////        
////			//	attach cart with user
////			user.setCart(cart);
////
////		}
////		// add the user
////		assertEquals("fail to add User", true, userDAO.addUser(user));
////
////	}
////
////	@Test
////	public void testUpdateCart() {
////		//fetch user by its email
////		user =userDAO.getByEmail("martin@gmail.com");
////		//get the cart of user
////		cart=user.getCart();
////		cart.setGrandTotal(25622);
////		cart.setCartLines(5);
////		assertEquals("fail to add User", true, userDAO.updateCart(cart));
//
//	// }
//
////	@Test
////	public void testAddress() {
////		
////		//add an user
////		
////		  user = new User();
////		  user.setFirstName("martin"); 
////		  user.setLastName("garix");
////		  user.setEmail("martin@gmail.com");
////		  user.setContactNumber("9998776655");
////		  user.setRole("USER");
////		  user.setPassword("12344");
////		  
////		  // add the user
////		  assertEquals("fail to add User", true,userDAO.addUser(user));
////		
////		// adding the billing Address
////		  
////
////		  address = new Address(); 
////		  address.setAddressLineOne("505");
////		  address.setAddressLineTwo("narmada"); 
////		  address.setCity("mumbai");
////		  address.setState("mh");
////		  address.setCountry("India");
////		  address.setPostalCode("401105");
////		  address.setBilling(true);
////	
////		  //attached the User To The Address
////		  
////		  address.setUser(user);
////		  assertEquals("Fail to add billing Address ", true, userDAO.addAddresss(address));
////		  
////		  
////		
////		  //adding shipping Address
////
////		  address = new Address(); 
////		  address.setAddressLineOne("503");
////		  address.setAddressLineTwo("armadanagar"); 
////		  address.setCity("thane");
////		  address.setState("mh"); 
////		  address.setCountry("India");
////		  address.setPostalCode("401105");
////		  // set shipping to true
////		  address.setShipping(true);
////		  
////		  
////		  address.setUser(user);
////		  assertEquals("Fail to add Shipping Address ", true, userDAO.addAddresss(address));
////		  
////		  
////	}
//
//	@Test
//	public void testAddress() {
//		
//
//		user=userDAO.getByEmail("martin@gmail.com");
//		
//		  address = new Address(); 
//		  address.setAddressLineOne("50s3");
//		  address.setAddressLineTwo("nagar"); 
//		  address.setCity("thansde");
//		  address.setState("mh"); 
//		  address.setCountry("India");
//		  address.setPostalCode("401105");
//		  // set shipping to true
//		  address.setShipping(true);
//		  
//		  
//		  address.setUser(user);
//		  
//		  assertEquals("Fail to add Shipping Address ", true, userDAO.addAddresss(address));
//		  
//	}
//
////	@Test
////	public void testGetAddress() {
////		user = userDAO.getByEmail("martin@gmail.com");
////
////		assertEquals("fail to featch the shipping Address", 2, userDAO.listShiipingAddress(user).size());
//
////		assertEquals("faild to featch the list of and size does not match","mumbai",
////				userDAO.getBillingAddress(user).getCity());
//	}
//}
