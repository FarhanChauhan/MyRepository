package in.ineuron.farhan.service;

import java.util.List;

import in.ineuron.farhan.model.Referral;

public interface IReferralService {

	public List<Referral> getAllReferral();
	public Referral saveReferral(Referral Referral);
	public Referral getReferralById(Long id);
	public void deleteReferralById(Long id);
}
