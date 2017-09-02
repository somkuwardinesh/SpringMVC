package spring.one.to.one.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import spring.one.to.one.dao.StudentDao;
import spring.one.to.one.model.Student;

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studentDao;
	
	public long saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Map<Long, String> getAllCources() {
		return studentDao.getAllCources();
	}
}
