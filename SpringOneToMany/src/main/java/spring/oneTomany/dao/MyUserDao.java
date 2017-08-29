package spring.oneTomany.dao;

import java.util.List;

import spring.oneTomany.model.MyUser;


public interface MyUserDao {

	public void saveMyUser(MyUser myUser);
	
	public void updateMyUser(MyUser myUser);
	
	
	public List<MyUser> getMyUserList();

	public MyUser findByID(long id);
	
	public MyUser findByName(String name);
	
	
	public void deleteMyUserById(long id);	
		
	
}
