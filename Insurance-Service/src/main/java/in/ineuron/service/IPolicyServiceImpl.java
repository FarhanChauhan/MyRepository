package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.exception.PolicyNotFoundException;
import in.ineuron.exception.StockNotFoundException;
import in.ineuron.model.InsurancePolicy;
import in.ineuron.model.StockPrice;
import in.ineuron.repository.IPolicyRepository;
import in.ineuron.repository.IStockRepository;

@Service
public class IPolicyServiceImpl implements IPolicyService {

	@Autowired
	private IPolicyRepository repo;
	
	@Override
	public String getPolicyById(Integer id) {
		Optional<InsurancePolicy> optional = repo.findById(id);
		if(optional.isPresent()) {
			InsurancePolicy policy = optional.get();
			return policy.getPolicyName();
		}
		throw new PolicyNotFoundException("Policy Not Available");
	}

}
