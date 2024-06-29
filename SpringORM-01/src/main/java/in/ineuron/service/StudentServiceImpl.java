package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDAO;
import in.ineuron.dto.StudentDTO;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO dao;
	
	@Override
	public String toString() {
		return "StudentServiceImpl [dao=" + dao + "]";
	}

	@Override
	public int insert(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.insert(bo);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void delete(StudentDTO dto) {
		StudentBO studentBO = new StudentBO();
		BeanUtils.copyProperties(dto, studentBO);
		dao.delete(studentBO);
	}

	@Override
	public void update(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		dao.update(bo);		
	}

	@Override
	public StudentDTO getStudent(int id) {
		StudentBO bo = dao.getStudent(id);
		StudentDTO dto = new StudentDTO();
		if(bo!=null)
			BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentBO> studentsBo = dao.getAllStudents();
		List<StudentDTO> studentDto = new ArrayList<StudentDTO>();
		studentsBo.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			studentDto.add(dto);
		});
		return studentDto;
	}

}
