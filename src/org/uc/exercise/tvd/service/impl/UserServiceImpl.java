package org.uc.exercise.tvd.service.impl;

import java.util.List;

import org.uc.exercise.tvd.dao.UserDAO;
import org.uc.exercise.tvd.dao.impl.UserDAOImpl;
import org.uc.exercise.tvd.service.UserService;
import org.uc.exercise.tvd.vo.UserVO;

public class UserServiceImpl implements UserService{
	UserDAO dao = new UserDAOImpl();
	
	public String insert(UserVO user){
		return dao.insert(user);
	}
	
	public boolean tableExist(){
		return dao.tableExist();
	}
	
	public int createTable(String qry){
		return dao.createTable(qry);
	}
	
	public UserVO validateUser(String user, String pwd){
		return dao.validateUser(user, pwd);
	}
	
	public List<UserVO> getUsers(){
		return dao.getUsers();
	}
	
	public byte[] getImage(Integer id){
		return dao.getImage(id);
	}
}
