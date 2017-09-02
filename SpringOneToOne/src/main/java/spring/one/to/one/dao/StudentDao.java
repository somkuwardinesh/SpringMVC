package spring.one.to.one.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import spring.one.to.one.model.Student;

@Repository
public interface StudentDao {

	public long saveStudent(Student student);
	
	public Map<Long, String> getAllCources();
	
	 
}
