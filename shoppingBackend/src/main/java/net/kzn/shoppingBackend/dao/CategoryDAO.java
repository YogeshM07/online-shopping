package net.kzn.shoppingBackend.dao;



import net.kzn.shoppingBackend.dto.Category;
import java.util.List;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);

}
