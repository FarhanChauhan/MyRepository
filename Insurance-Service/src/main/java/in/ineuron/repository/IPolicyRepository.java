package in.ineuron.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.StockPrice;
import in.ineuron.model.InsurancePolicy;

public interface IPolicyRepository extends JpaRepository<InsurancePolicy,Integer>{

	public Optional<InsurancePolicy> findById(Integer policyId);
}
