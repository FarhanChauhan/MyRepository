package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;

@Service
public class EmployeeMgmntServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public List<EmployeeDTO> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {
		List<EmployeeBO> empBO = dao.fetchEmployeesByDesg(desg1, desg2, desg3);
		List<EmployeeDTO> empDTO = new ArrayList<EmployeeDTO>();
		empBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			empDTO.add(dto);
		});
		return empDTO;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.registerEmployee(bo)==1?"Record inserted successfully":"Record insertion failed";
	}

	@Override
	public String fetchEmployeeByNo(int no) {
		return dao.getEmployeeByName(no) ;
	}

}
