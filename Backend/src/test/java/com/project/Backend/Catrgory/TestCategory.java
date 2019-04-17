//package com.project.Backend.Catrgory;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.project.Backend.DAO.CategoryDAO;
//import com.project.Backend.Model.Category;
//
//public class TestCategory {
//	public static AnnotationConfigApplicationContext context;
//
//	public static CategoryDAO categoryDAO;
//
//	private Category category;
//
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com");
//		context.refresh();
//		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
//
//	}
//
////	@Test
////	public void addCategory() {
////		category = new Category();
////			category.setName("mobile");
////		category.setDescription("This is mobile");
////		category.setImageUrl(".png");
////		
////		assertEquals("Sucessfully added in category", true, categoryDAO.add(category));
////
////	}
////	
////	@Test
////	public void getCategory() {
////	category=categoryDAO.get(3);
////	assertEquals("sucessfull get by id a single ","mobile",category.getName());
////	}
//
////	@Test
////	public void updateCategory() {
////	category=categoryDAO.get(3);
////	category.setImageUrl("45street"); 
////	assertEquals("sucessfull update ",true,categoryDAO.update(category));
////	}
////	
////	@Test
////	public void deleteCategory() {
////	category=categoryDAO.get(3);
////	
////	assertEquals("sucessfull delete ",true,categoryDAO.delete(category));
////	}
////
////	@Test	
////	public void listCategory() {
////
////	
////	assertEquals("sucessfull list of Category ",2,categoryDAO.CList().size());
////	}
//
////	@Test
////	public void CRUD() {
//
////			
////		//ADDING.....................
////		
////		category = new Category();
////		category.setName("CAMERA");
////		category.setDescription("This is Camera");
////		category.setImageUrl("2.png");
////
////		assertEquals("Sucessfully added in category", true, categoryDAO.add(category));
////
////		category = new Category();
////		category.setName("Mobile");
////		category.setDescription("This is Mobile");
////		category.setImageUrl("3.png");
////
////		assertEquals("Sucessfully added in category", true, categoryDAO.add(category));
////
////		// updating.....................................
////
////		category = categoryDAO.get(1);
////		category.setImageUrl("1.png");
////		assertEquals("sucessfull update ", true, categoryDAO.update(category));
////
////
////	// deleting...........................................
////
////	category=categoryDAO.get(2);
////	
////	assertEquals("sucessfull delete ",true,categoryDAO.delete(category));
//	
//
//	//list.................................................
//	//assertEquals("sucessfull list of Category ",2,categoryDAO.CList().size());
//	
//	}
////}
