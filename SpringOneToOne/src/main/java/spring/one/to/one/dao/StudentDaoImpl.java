package spring.one.to.one.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import spring.one.to.one.model.Course;
import spring.one.to.one.model.Student;

public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public long saveStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t =session.beginTransaction();
		Long id=(Long)session.save(student);
		t.commit();
		session.flush();
		session.close();
		return id;
	}
	
	public Map<Long, String> getAllCources() {
		Map<Long, String> cmap = new HashMap<Long, String>();
		Session session = sessionFactory.openSession();
		Criteria criteria =session.createCriteria(Course.class);
		List<Course> list = criteria.list();
		for (Course course : list) {
			cmap.put(course.getId(), course.getCourseName());
		}
			
		return cmap;
	}
}
