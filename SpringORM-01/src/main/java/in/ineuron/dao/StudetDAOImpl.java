package in.ineuron.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudetDAOImpl implements IStudentDAO {

	@Autowired
	private HibernateTemplate template;

	@Override
	public int insert(StudentBO bo) {
		int rowAffected = (Integer) template.save(bo);
		return rowAffected;
	}

	@Override
	public void delete(int id) {
		StudentBO studentBO = template.get(StudentBO.class,id);
		if(studentBO!=null) {
			template.delete(studentBO);
			System.out.println("Record deleted successfully...");
		}
		else {
			System.out.println("no Record available for the given id : "+ id);
		}
	}

	@Override
	public void delete(StudentBO bo) {
		if(bo!=null) {
			StudentBO stdRecord = template.get(StudentBO.class,bo.getSid());
			template.delete(stdRecord);
			System.out.println("Record deleted successfully..");
		}else {
			System.out.println("Record not available for the given id ");
		}

	}

	@Override
	public void update(StudentBO bo) {
		template.merge(bo);
	}

	@Override
	public StudentBO getStudent(int id) {
		StudentBO bo = template.get(StudentBO.class,id);
		return bo;
	}

	@Override
	public List<StudentBO> getAllStudents() {
		List<StudentBO> students = template.loadAll(StudentBO.class);
		return students;
	}

}
