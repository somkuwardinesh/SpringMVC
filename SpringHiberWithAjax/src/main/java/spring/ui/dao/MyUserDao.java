package spring.ui.dao;

import java.util.List;

import spring.ui.model.MyUser;

public interface MyUserDao {

	public void saveMyUser(MyUser myUser);
	
	public void updateMyUser(MyUser myUser);
	
	
	public List<MyUser> getMyUserList();

	public MyUser findByID(long id);
	
	public MyUser findByName(String name);
	
	
	public void deleteMyUserById(long id);	
	
	
	
}
