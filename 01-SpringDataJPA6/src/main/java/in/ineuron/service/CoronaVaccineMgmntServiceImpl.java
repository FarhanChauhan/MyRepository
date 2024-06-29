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
import in.ineuron.dao.ICoronaVaccineRepo
import in.ineuron.type.ResultView1;
import in.ineuron.type.View;

@Service(value="service")
public class CoronaVaccineMgmntServiceImpl implements ICoronaVaccineMgmntService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public <T extends View> List<T> searchVaccineByCompany(String company, Class<T> clazz) {
		
		return repo.findByCompanyOrderByCompanyDesc(company,clazz);
	}

	
}
