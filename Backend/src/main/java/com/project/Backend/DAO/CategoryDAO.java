package com.project.Backend.DAO;

import java.util.List;

import com.project.Backend.Model.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	List<Category> CList();
	Category get(int id);
}
