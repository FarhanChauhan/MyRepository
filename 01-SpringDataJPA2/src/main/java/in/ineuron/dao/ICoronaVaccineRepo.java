package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine,Integer>,PagingAndSortingRepository<CoronaVaccine,Integer>{

	
}

