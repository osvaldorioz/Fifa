package org.uc.exercise.tvd.dao;

import java.util.List;

import org.uc.exercise.tvd.vo.UserVO;

public interface UserDAO {
	boolean tableExist();
	String insert(UserVO user);
	int createTable(String qry);
	UserVO validateUser(String user, String pwd);
	List<UserVO> getUsers();
	byte[] getImage(Integer id);
}
