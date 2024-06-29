package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service(value="service")
public class CoronaVaccineMgmntServiceImpl implements ICoronaVaccineMgmntService {

	@Autowired
	private ICoronaVaccineRepo repo;
	@Override
	public String regusterVaccine(CoronaVaccine vaccine) {
		System.out.println("In memory proxy class is : "+repo.getClass().getName());
		CoronaVaccine saveVaccine = null;
		if(vaccine !=null) {
			saveVaccine = repo.save(vaccine);
		}
		return saveVaccine!=null?"Vaccine registerd successfully...":"Vaccine registration failed...";
	}
	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
		if(vaccines!=null) {
			Iterable<CoronaVaccine> saveAll = repo.saveAll(vaccines);
		}
		else {
			new IllegalArgumentException("Batch insertion not done ...");
		}
		return null;
	}
	@Override
	public boolean checkAvailibilityByRegNo(Integer regNo) {
		return repo.existsById(regNo);
	}
	@Override
	public Long getCountVaccines() {
		return repo.count();
	}
	@Override
	public Iterable<CoronaVaccine> fetchAllRecords() {
		return repo.findAll();
	}
	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsById(Iterable<Integer> regNo) {
		return repo.findAllById(regNo);
	}
	@Override
	public Optional<CoronaVaccine> fetchRecordById(Integer regNo) {
		return repo.findById(regNo);
	}
	@Override
	public String deleteById(Integer regNo) {
		Optional<CoronaVaccine> optional = repo.findById(regNo);
		if(optional.isPresent()) {
			repo.deleteById(regNo);	
			return "Record deleted successfully";
		}
		else 
			return "Record not availble for deletion";
	}
	@Override
	public String removeVaccineObject(CoronaVaccine vaccine) {
		Optional<CoronaVaccine> optional = repo.findById(vaccine.getRegNo());
		if(optional.isPresent()) {
			repo.delete(vaccine);
			return "Record deleted successfully with the id : "+vaccine.getRegNo();
		}
		else
			return "No Record foound for Deletion for the id : "+vaccine.getRegNo();
	}
	@Override
	public String removeAllById(List<Integer> ids) {
		List<CoronaVaccine> ilistIds = (List<CoronaVaccine>) repo.findAllById(ids);
		if(ids.size()==ilistIds.size()) {
			repo.deleteAllById(ids);
			return "Records deleted successfully";
		}
		else
			return "Problem in deletion ";
	}
	
	
}
