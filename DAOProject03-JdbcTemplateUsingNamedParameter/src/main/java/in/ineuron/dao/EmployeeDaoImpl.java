package in.ineuron.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private String GET_EMPLOYEE_BY_NAME="SELECT ENAME FROM employee where eid=:no";
	private String INSERT_EMPLOYEE="INSERT INTO employee(`ename`,`eage`,`esal`,`eaddress`,`desg`)values(:ename,:eage,:esal,:eaddress,:desg)";
	private String GET_EMPLOYEE_BY_DESG="SELECT eid,ename,eaddress,esal,desg from employee where desg in(:desg1,:desg2,:desg3)";
	
	@Override
	public List<EmployeeBO> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {

		MapSqlParameterSource map = new MapSqlParameterSource();
		
		map.addValue("desg1",desg1);
		map.addValue("desg2",desg2);
		map.addValue("desg3",desg3);
		
		return template.query(GET_EMPLOYEE_BY_DESG, map,(ResultSetExtractor<List<EmployeeBO>>)rs->{
			List<EmployeeBO> empBO = new ArrayList<EmployeeBO>();
			while(rs.next())
			{
				EmployeeBO bo = new EmployeeBO();
				bo.setEid(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setEaddress(rs.getString(3));
				bo.setEsal(rs.getInt(4));
				bo.setDesg(rs.getString(5));
				empBO.add(bo);
			}
			return empBO;
		});
	}

	@Override
	public int registerEmployee(EmployeeBO bo) {
		
		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(bo);
		return template.update(INSERT_EMPLOYEE, map);
	}

	@Override
	public String getEmployeeByName(int no) {
		Map<String,Integer> map = Map.of("no",no);
		return template.queryForObject(GET_EMPLOYEE_BY_NAME, map, String.class);
	}

}
