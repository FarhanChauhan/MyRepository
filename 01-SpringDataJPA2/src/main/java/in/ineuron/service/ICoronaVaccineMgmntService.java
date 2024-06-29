package in.ineuron.service;

import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmntService {

	public Iterable<CoronaVaccine> sortByPrice(boolean asc,String ...properties);
	public Iterable<CoronaVaccine> orderInPages(int pageNo,int pageSize,boolean asc,String ...properties);
	public void displayAllPages(int pageSize);
}
