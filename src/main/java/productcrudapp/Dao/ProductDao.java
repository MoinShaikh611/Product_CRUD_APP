package productcrudapp.Dao;	

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
//	creating and updating  the product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}

	
	//get all products	
	public List<Product> getProducts(){
		return this.hibernateTemplate.loadAll(Product.class);
	}
	
//	delete the single product
	@Transactional
	public void deleteProduct(int pid) {
//		first fetch 
		Product p = this.hibernateTemplate.load(Product.class,pid);
		
//		then delete
		this.hibernateTemplate.delete(p);
	}
	
//	get the single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
		
	}
}
