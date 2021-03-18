package net.kzn.shoppingBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingBackend.dao.CategoryDAO;
import net.kzn.shoppingBackend.dto.Category;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category cat = new Category();
		cat.setId(1);
		cat.setName("Television");
		cat.setDescription("this is Description for television !");
		cat.setImageURL("CAT_1.png");

		categories.add(cat);

		cat = new Category();
		cat.setId(2);
		cat.setName("Mobile");
		cat.setDescription("this is Description for Mobile !");
		cat.setImageURL("CAT_2.png");

		categories.add(cat);

		cat = new Category();
		cat.setId(3);
		cat.setName("Laptop");
		cat.setDescription("this is Description for Laptop !");
		cat.setImageURL("CAT_3.png");

		categories.add(cat);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
