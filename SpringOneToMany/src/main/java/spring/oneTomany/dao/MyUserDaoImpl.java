package spring.oneTomany.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import spring.oneTomany.model.Images;
import spring.oneTomany.model.MyUser;


public class MyUserDaoImpl implements MyUserDao {

	@Autowired
	SessionFactory sessionFactory;

	public void saveMyUser(MyUser myUser) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (myUser != null) {
			try {
				session.save(myUser);
				t.commit();
				session.close();
			} catch (Exception e) {
				t.rollback();
				session.close();
			}
		}
	}


}
