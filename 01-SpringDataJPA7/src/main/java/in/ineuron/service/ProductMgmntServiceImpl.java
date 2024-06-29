package in.ineuron.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service(value="service")
public class ProductMgmntServiceImpl implements IProductMgmntService{

	@Autowired
	private EntityManager manager;

	@Override
	public List<Product> fetchProductByName(String product1, String product2) {
		
		System.out.println(manager.getClass().getName());
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_get_product_details_by_name",Product.class);
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		
		query.setParameter(1, product1);
		query.setParameter(2, product2);
		
		List listProducts = query.getResultList();
		return listProducts;
}
}
