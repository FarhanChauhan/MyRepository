package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.bo.MarraigeSeeker;

public interface IMatromonyMgmntService {

	public String addSeeker(MarraigeSeeker seeker);
	public Optional<MarraigeSeeker> fetchSeekersById(Integer id);

}
