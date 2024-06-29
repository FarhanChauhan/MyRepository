package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmntService {

	public List<CoronaVaccine> fetchVaccineByCompany(String company);
	public List<CoronaVaccine> fetchByCompanyInAndPriceBetween(Collection<String> company,Integer startRange,Integer endRange);
	public List<CoronaVaccine> fetchByPriceLessThan(Integer price);
	public List<CoronaVaccine> fetchSByCountryNotIn(Collection<String> countries);
}
