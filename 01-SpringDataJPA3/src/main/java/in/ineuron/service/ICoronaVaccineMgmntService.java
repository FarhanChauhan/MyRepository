package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmntService {
	public List<CoronaVaccine> getVaccineyDetail(CoronaVaccine vaccine ,boolean order ,String propperties);
	public CoronaVaccine getVaccineById(Integer regNo);
	public String removeAllbyRegNo(List<Integer> ids);
}
