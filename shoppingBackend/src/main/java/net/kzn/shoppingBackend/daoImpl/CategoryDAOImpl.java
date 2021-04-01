package net.kzn.shoppingBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingBackend.dao.CategoryDAO;
import net.kzn.shoppingBackend.dto.Category;

@Repository("CategoryDAO")
@Transactional                                  // every method handdle as transactional 
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	@Autowired
	private SessionFactory sessionFactory;     // autowired with HibernateConfif class

	/*
	 * static {
	 * 
	 * Category cat = new Category(); cat.setId(1); cat.setName("Television");
	 * cat.setDescription("this is Description for television !");
	 * cat.setImageURL("CAT_1.png");
	 * 
	 * categories.add(cat);
	 * 
	 * cat = new Category(); cat.setId(2); cat.setName("Mobile");
	 * cat.setDescription("this is Description for Mobile !");
	 * cat.setImageURL("CAT_2.png");
	 * 
	 * categories.add(cat);
	 * 
	 * cat = new Category(); cat.setId(3); cat.setName("Laptop");
	 * cat.setDescription("this is Description for Laptop !");
	 * cat.setImageURL("CAT_3.png");
	 * 
	 * categories.add(cat); }
	 */

	@Override
	public List<Category> list() {
		
	String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		
		Category category = sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));	

		/*
		 * for (Category category : categories) { if (category.getId() == id) { return
		 * category; } }
		 */
		return category;
	}

	@Override
	
	public boolean add(Category category) {
	 
		try {
			
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
	
	try {
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
	try {
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
