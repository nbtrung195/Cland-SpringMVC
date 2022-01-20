package cland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cland.dao.UserDao;
import cland.model.user;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public user login(user User) {
		try {
			userDao.login(User);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return userDao.login(User);
	}
	
	public List<user> ListUser(){
		try {
			userDao.selectAllItems();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return userDao.selectAllItems();
	}
	
	public int addUser(user user) {
		return userDao.addItem(user);
	}
	
	public int delUser(user user) {
		return userDao.dellItem(user);
	}
	
	public user ExistedUser(user user) {
		try {
			userDao.ExistedItem(user);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return userDao.ExistedItem(user);
	}
	
	public user selectUserById(user user) {
		try {
			userDao.selectItemById(user);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return userDao.selectItemById(user);
	}
	
	public int EditUser(user user) {
		return userDao.editItem(user);
	}
	
}
