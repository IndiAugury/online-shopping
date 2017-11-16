/**
 * 
 */
package com.indiaugury.shoppingbackend.dao;

import java.util.List;

import com.indiaugury.shoppingbackend.dto.Category;

/**
 * @author sanchitp
 *
 */
public interface CategoryDAO {
	
	boolean add(Category category);
	
	List<Category> list();

	Category get(int id);

}
