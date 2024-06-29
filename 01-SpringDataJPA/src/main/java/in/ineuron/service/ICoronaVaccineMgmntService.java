package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmntService {

	public String regusterVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
	public boolean checkAvailibilityByRegNo(Integer regNo);
	public Long getCountVaccines();
	public Iterable<CoronaVaccine> fetchAllRecords();
	public Iterable<CoronaVaccine> fetchAllDetailsById(Iterable<Integer> regNo);
	public Optional<CoronaVaccine> fetchRecordById(Integer regNo);
	public String deleteById (Integer regNo);
	public String removeVaccineObject(CoronaVaccine vaccine);
	public String removeAllById(List<Integer> ids);
}
