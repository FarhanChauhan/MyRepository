package in.ineuron.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {

	public int getEmployeeCount();
	public String getEmployeeNameById(int eno);
	public Map<String,Object>getEmployeedetailsById(int eno);
	public List<Map<String,Object>>getEmployeedetailsByaddresss(String addr1,String addr2);
	public int insertEmployee(String ename,int esal,String eaddress);
	public int addBonusByAge(int bonus,String addresss );
}
