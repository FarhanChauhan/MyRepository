package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service(value="service")
public class CoronaVaccineMgmntServiceImpl implements ICoronaVaccineMgmntService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company) {
		
		List<CoronaVaccine> list = repo.findByCompany(company);
		repo.findByCompanyEquals(company).forEach(System.out::println);
		repo.findByCompanyIs(company).forEach(System.out::println);
		return list;
	}

	@Override
	public List<CoronaVaccine> fetchByCompanyInAndPriceBetween(Collection<String> company, Integer startRange,
			Integer endRange) {
		List<CoronaVaccine> list = repo.findByCompanyInAndPriceBetween(company, startRange, endRange);
		return list;
	}

	@Override
	public List<CoronaVaccine> fetchByPriceLessThan(Integer price) {
		List<CoronaVaccine> list = repo.findByPriceLessThan(price);
		return list;
	}

	@Override
	public List<CoronaVaccine> fetchSByCountryNotIn(Collection<String> countries) {
		List<CoronaVaccine> list = repo.findByCountryNotIn(countries);
		return list;
	}

	
	
}
