package in.ineuron.service;

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
	public List<CoronaVaccine> getVaccineyDetail(CoronaVaccine vaccine, boolean order, String properties) {
		
		Example<CoronaVaccine> example = Example.of(vaccine);
		Sort sort = Sort.by(order?Direction.ASC:Direction.DESC,properties);
		List<CoronaVaccine> list = repo.findAll(example, sort);
		return list;
	}

	@Override
	public CoronaVaccine getVaccineById(Integer regNo){
		
		@SuppressWarnings("deprecation")
		CoronaVaccine vaccine = repo.getById(regNo);
		return vaccine;
	}

	@Override
	public String removeAllbyRegNo(List<Integer> ids) {
		
		List<CoronaVaccine> listEntities = repo.findAllById(ids);
		if(listEntities.size()!=0) {
			repo.deleteAllByIdInBatch(ids);
			System.out.println( listEntities.size()+" Records deleted successfully..");
		}
		return " Records not found for deletion";
	}	
	
}
