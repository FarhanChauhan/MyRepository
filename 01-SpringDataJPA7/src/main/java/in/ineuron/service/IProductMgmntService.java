package in.ineuron.service;

import java.util.List;
import in.ineuron.bo.Product;

public interface IProductMgmntService {

	public List<Product> fetchProductByName(String product1,String product2);

}
