package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;

public interface ICoronaVaccineMgmntService {

	public List<ResultView> searchVaccineByStartPrice(Integer price);

}
