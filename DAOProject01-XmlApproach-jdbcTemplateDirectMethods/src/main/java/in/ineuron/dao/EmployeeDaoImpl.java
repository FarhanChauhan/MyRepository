package in.ineuron.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements IEmployeeDao {

	private JdbcTemplate template;
	private static final String ADD_BONUS_BY_AGE="UPDATE employee SET esal=esal+? where eaddress=?";
	private static final String INSERT_EMPLOYEE="INSERT INTO employee(ename,esal,eaddress) values(?,?,?)";
	private static final String GET_EMPLOYEE_BY_ADDRESS="SELECT eid,ename,esal,eaddress from employee where eaddress IN (?,?) order by esal";
	private static final String GET_EMPLOYEE_BY_NO="SELECT eid,ename,esal,eaddress from employee where eid=?";
	private static final String SQL_SELECT_QUERY_BY_ID="SELECT ename from employee where eid =?";
	private static final String SQL_COUNT_QUERY="SELECT count(*) from employee";
	
	
	public EmployeeDaoImpl(JdbcTemplate template) {
		this.template=template;
	}
	@Override
	public int getEmployeeCount() {
		return template.queryForObject(SQL_COUNT_QUERY, Integer.class); 
	}

	@Override
	public String getEmployeeNameById(int eno) {
		return template.queryForObject(SQL_SELECT_QUERY_BY_ID, String.class,eno); 
	}
	@Override
	public Map<String, Object> getEmployeedetailsById(int eno) {
		Map<String, Object> map = template.queryForMap(GET_EMPLOYEE_BY_NO,eno);
		return map;
	}
	@Override
	public List<Map<String, Object>> getEmployeedetailsByaddresss(String addr1, String addr2) {
		List<Map<String, Object>> list = template.queryForList(GET_EMPLOYEE_BY_ADDRESS,addr1,addr2);
		return list;
	}
	@Override
	public int insertEmployee(String ename, int esal, String eaddress) {
		return template.update(INSERT_EMPLOYEE,ename,esal,eaddress);
	}
	@Override
	public int addBonusByAge(int bonus, String address) {
		return template.update(ADD_BONUS_BY_AGE,bonus,address);
	}

}
