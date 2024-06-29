package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.MarraigeSeeker;
import in.ineuron.dao.IMatromonyRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service(value="service")
public class MatromonyMgmntServiceImpl implements IMatromonyMgmntService{

	@Autowired
	private IMatromonyRepo repo;

	@Override
	public String addSeeker(MarraigeSeeker seeker) {
		Integer id =((MarraigeSeeker) repo.save(seeker)).getId();
		return "Seeker added with the id : " + id;
	}

	@Override
	public Optional<MarraigeSeeker> fetchSeekersById(Integer id) {
	Optional<MarraigeSeeker> optional = repo.findById(id);
		return optional;
	}

	
}
