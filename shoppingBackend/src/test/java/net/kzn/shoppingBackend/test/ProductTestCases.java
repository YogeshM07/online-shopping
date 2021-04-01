package net.kzn.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingBackend.dao.CategoryDAO;
import net.kzn.shoppingBackend.dao.ProductDAO;
import net.kzn.shoppingBackend.dto.Category;
import net.kzn.shoppingBackend.dto.Product;

public class ProductTestCases {

	
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	

	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingBackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO"); /// if you put categoryDAO (small 'c' then it will give u error)
		                                                               //it should be match with @Repository("CategoryDAO") 
	}
	
	@Test
	public void testCRUDProduct() {
		
		
		product = new Product();
		
//		product.setName("Oppo Selfie S53");
//		product.setBrand("Oppo");
//		product.setDescription("This is some description for oppo mobile phones!");
//		product.setUnitPrice(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
		
//		product = productDAO.get(6);
//		product.setName("Oppo Selfie M101");
//		assertEquals("Something went wrong while updating the existing record!",
//				true,productDAO.update(product));	
//		
//		assertEquals("Something went wrong while deleting the existing record!",
//				true,productDAO.delete(product));	
		
		assertEquals("Something went wrong while fetching the list of products!",
				6,productDAO.list().size());	
	}
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProducts().size());				
	} 
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} 
	
}
