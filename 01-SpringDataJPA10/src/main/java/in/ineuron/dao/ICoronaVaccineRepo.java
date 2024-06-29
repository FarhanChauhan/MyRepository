package in.ineuron.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Integer>{

	public List<CoronaVaccine> findByCompany(String company);
	public List<CoronaVaccine> findByCompanyEquals(String company);
	public List<CoronaVaccine> findByCompanyIs(String company);
	public List<CoronaVaccine> findByCompanyInAndPriceBetween(Collection<String> company,Integer startRange,Integer endRange);
	public List<CoronaVaccine> findByPriceLessThan(Integer price);
	public List<CoronaVaccine> findByCountryNotIn(Collection<String> countries);
	
}

