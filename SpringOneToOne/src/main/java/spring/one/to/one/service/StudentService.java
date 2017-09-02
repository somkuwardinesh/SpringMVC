package spring.one.to.one.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import spring.one.to.one.model.Student;

@Service
public interface StudentService {

	public long saveStudent(Student student);
	public Map<Long, String> getAllCources();
}
