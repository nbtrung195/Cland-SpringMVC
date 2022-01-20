package cland.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cland.constant.sql.ContactSQL;
import cland.model.contact;

@Repository
public class ContactDao extends AbstractDao<contact>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<contact> selectAllItems() {
		// TODO Auto-generated method stub
		 return jdbcTemplate.query(ContactSQL.ALL_CONTACT, new BeanPropertyRowMapper<>(contact.class));
	}

	@Override
	public contact selectItemById(contact contact) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(ContactSQL.SELECT_CONTACT_BY_ID, new BeanPropertyRowMapper<>(contact.class), new Object[] {contact.getCid()});
	}

	@Override
	public int addItem(contact contact) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(ContactSQL.ADD_CONTACT, new Object[] {contact.getFullname(), contact.getEmail(), contact.getContent()});
	}

	@Override
	public int editItem(contact t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dellItem(contact contact) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(ContactSQL.DEL_CONTACT, new Object[] {contact.getCid()});
	}
	
}
