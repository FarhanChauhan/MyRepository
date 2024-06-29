package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.StockPrice;

public interface IStockRepository extends JpaRepository<StockPrice,Integer>{

	public StockPrice findByCompanyName(String companyName);
}
