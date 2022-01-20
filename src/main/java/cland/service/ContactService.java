package cland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cland.dao.ContactDao;
import cland.model.contact;

@Service
public class ContactService {

	@Autowired
	private ContactDao contactDao;
	
	public List<contact> ListContact(){
		try {
			contactDao.selectAllItems();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return contactDao.selectAllItems();
	}
	
	public contact gettContactById(contact contact) {
		try {
			contactDao.selectItemById(contact);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return contactDao.selectItemById(contact);
	}
	
	public int delContact(contact contact) {
		return contactDao.dellItem(contact);
	}
	
	public int addContact(contact contact) {
		return contactDao.addItem(contact);
	}
	
}
