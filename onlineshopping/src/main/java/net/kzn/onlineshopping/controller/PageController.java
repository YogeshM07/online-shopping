package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingBackend.dao.CategoryDAO;
import net.kzn.shoppingBackend.dao.ProductDAO;
import net.kzn.shoppingBackend.dto.Category;
import net.kzn.shoppingBackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index() {
		
		logger.info("inside page controller index method--INFO");
		logger.debug("inside page controller index method--DEBUG");
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");		
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv ;
	}
	
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv ;
	}
	
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv ;
	}
	
	// load product based on category
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllproducts",true);
		return mv ;
	}
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("page");
	  
		Category category=categoryDAO.get(id); 
		
		mv.addObject("category", category);
		mv.addObject("title","All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickcategoryproducts",true);
		return mv ;
	}
	
	
	@RequestMapping(value = {"show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		
		Product product =productDAO.get(id);
		
		if (product==null) throw new ProductNotFoundException(); 
		
		product.setViews(product.getViews()+1);
		
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		
		
		
		return mv;
	}
}
