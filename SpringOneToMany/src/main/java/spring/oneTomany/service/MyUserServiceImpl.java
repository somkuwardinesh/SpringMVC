package spring.oneTomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.oneTomany.dao.MyUserDao;
import spring.oneTomany.model.MyUser;



public class MyUserServiceImpl implements MyUserService{

	@Autowired
	private MyUserDao myUserDAo;

	public void saveMyUser(MyUser myUser) {
		myUserDAo.saveMyUser(myUser);
	}
}
