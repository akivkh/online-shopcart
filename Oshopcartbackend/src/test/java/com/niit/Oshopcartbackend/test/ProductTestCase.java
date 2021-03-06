package com.niit.Oshopcartbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Oshopcartbackend.Dao.ProductDao;
import com.niit.Oshopcartbackend.model.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDao productDao;
	private static Product product;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Oshopcartbackend");
		context.refresh();
		productDao=(ProductDao) context.getBean("productDao");
	}
	/*@Test
	public void testAddProduct() {
		product=new Product();
		product.setCode("PRDABCXYZPQRS");
		product.setName("Acer Aspire E15");
		product.setBrand("Acer");
		product.setDescription("This is one of the best laptop available in market");
		product.setUnitPrice(40000);
		product.setQuantity(3);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(3);
		product.setPurchases(0);
		product.setViews(0);
		
		assertEquals("Succesfully  Inserting a new Product ",true,productDao.add(product));
	}*/

	/*@Test
	public void testCRUDProduct() {
		
		//create operation
		product = new Product();
		product.setName("Oppo f7");
		product.setBrand("Oppo");
		product.setDescription("this is some description for Oppo phone");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while Inserting a new Product!",true,productDao.add(product));
		 
		
		//reading and updating the Category
		
		product =productDao.get(2);
		product.setName("Redmi 4");
		
		assertEquals("Something went wrong while Updating the exsisting record!",true,productDao.update(product));
		
		assertEquals("Something went wrong while Deleting the exsisting record!",true,productDao.delete(product));
		
		//list
		
		assertEquals("Something went wrong while fetching  the the list of product!",6,productDao.list().size());
		
	}*/
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDao.listActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDao.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDao.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDao.getLatestActiveProducts(3).size());
		
	} 
	
}
	

