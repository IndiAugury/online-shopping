/**
 * 
 */
package com.indiaugury.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indiaugury.shoppingbackend.dao.CategoryDAO;
import com.indiaugury.shoppingbackend.dto.Category;

/**
 * @author sanchitp
 *
 */
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> catetogies= new ArrayList<>();
	
	static{
	
		Category category= new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is Television Category");
		category.setImageURL("CAT_1.png");
		
		catetogies.add(category);
		
		// Second
		category= new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Mobile Category");
		category.setImageURL("CAT_2.png");
		
		catetogies.add(category);
		
		//Third 
		category= new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Laptop Category");
		category.setImageURL("CAT_3.png");
		
		catetogies.add(category);
		
	}

	/* (non-Javadoc)
	 * @see com.indiaugury.shoppingbackend.dao.CategoryDAO#list()
	 */
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return catetogies;
	}

	@Override
	public Category get(int id) {
		
		//for each or enhance for loop 
		for (Category category : catetogies) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			//Add category to DB
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

}
