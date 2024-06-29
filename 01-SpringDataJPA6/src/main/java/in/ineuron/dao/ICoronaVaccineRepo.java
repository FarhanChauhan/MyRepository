package in.ineuron.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;
import in.ineuron.type.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Integer>{

	public <T extends View>  List<T> findByCompanyOrderByCompanyDesc(String company,Class<T> clazz);
	
}

