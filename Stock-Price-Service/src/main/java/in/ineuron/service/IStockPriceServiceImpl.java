package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.exception.StockNotFoundException;
import in.ineuron.model.StockPrice;
import in.ineuron.repository.IStockRepository;

@Service
public class IStockPriceServiceImpl implements IStockPriceService {

	@Autowired
	private IStockRepository repo;
	
	@Override
	public Double getByCompanyName(String companyName) {
		StockPrice stockPrice = repo.findByCompanyName(companyName);
		if(stockPrice==null) {
			throw new StockNotFoundException("Company Not Available ...");
		}
		return stockPrice.getCompanyPrice();
	}

}
