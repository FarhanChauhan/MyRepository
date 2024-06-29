package in.ineuron.service;

import java.util.List;
import java.util.Map;


public interface IEmployeeService {

	public int fetchEmployeeCount();
	public String fetchEmployeeNameById(int eno);
	public Map<String,Object>fetchEmployeedetailsById(int eno);
	public List<Map<String,Object>>fetchEmployeedetailsByaddresss(String addr1,String addr2);
	public int insertEmployee(String ename,int esal,String eaddress);
	public int addBonusByAge(int bonus,String address );
}
