package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristMgmtService {
	public String saveTourist(Tourist tourist);
	public List<Tourist> displayTourists();
	public Tourist displayTouristById(Integer id);
	public String updateTourisr(Tourist tourist);
	public String updateTouristById(Integer id,float hike);
	public String deleteTouristById(Integer id);
}
