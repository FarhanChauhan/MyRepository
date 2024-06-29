package in.ineuron.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IEmployeeDao;

@Service
public class EmployeeSericeImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public int fetchEmployeeCount() {
		return dao.getEmployeeCount();
	}

	@Override
	public String fetchEmployeeNameById(int eno) {
		return dao.getEmployeeNameById(eno);
	}

	@Override
	public Map<String, Object> fetchEmployeedetailsById(int eno) {
		return dao.getEmployeedetailsById(eno);
	}

	@Override
	public List<Map<String, Object>> fetchEmployeedetailsByaddresss(String addr1, String addr2) {
		return dao.getEmployeedetailsByaddresss(addr1,addr2);
	}

	@Override
	public int insertEmployee(String ename, int esal, String eaddress) {
		return dao.insertEmployee(ename, esal, eaddress);
	}

	@Override
	public int addBonusByAge(int bonus, String addresss) {
		return dao.addBonusByAge(bonus, addresss);
	}

}
