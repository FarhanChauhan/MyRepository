package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<CoronaVaccine> sortByPrice(boolean asc, String... properties) {
		
		Sort sort =Sort.by(asc?Sort.Direction.ASC:Sort.Direction.DESC ,properties);
		Iterable<CoronaVaccine> list = repo.findAll(sort);
		return list;
	}

	@Override
	public Iterable<CoronaVaccine> orderInPages(int pageNo, int pageSize, boolean asc, String... properties) {
		
		PageRequest pageable= PageRequest.of(pageNo, pageSize, asc?Direction.ASC:Direction.DESC ,properties);
		Page<CoronaVaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void displayAllPages(int pageSize) {
		
		long totalRecords = repo.count();
		int pageCount =(int) (totalRecords/pageSize);
		pageCount =totalRecords%pageSize==0?pageCount:++pageCount;
		
		for(int i=0;i<pageCount;i++) {
			PageRequest pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("Page No ============ "+(i+1)+ " of Page "+pageCount);
		}
		
	}

	
	
}
