package in.ineuron.farhan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.farhan.dao.ReferralRepository;
import in.ineuron.farhan.exception.ReferralNotFoundExcepton;
import in.ineuron.farhan.model.Referral;

@Service("service")
public class ReferralServiceImpl implements IReferralService {

	@Autowired
	private ReferralRepository repo;

	@Override
	public List<Referral> getAllReferral() {
		return (List<Referral>) repo.findAll();
	}

	@Override
	public Referral saveReferral(Referral Referral) {
		return repo.save(Referral);
	}

	@Override
	public Referral getReferralById(Long id) {
		Referral Referral =repo.findById(id).orElseThrow(()-> new ReferralNotFoundExcepton(
			"Referral does not exists with the id : "+id));
		return Referral;
	}
	
	@Override
	public void deleteReferralById(Long id) {
		Referral Referral = repo.findById(id)
				.orElseThrow(() ->
				new ReferralNotFoundExcepton("Record not exists with the id:: " + id));
		repo.delete(Referral);
	}
	
}
