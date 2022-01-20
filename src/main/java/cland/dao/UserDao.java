package cland.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cland.constant.sql.UserSQL;
import cland.model.user;
@Repository
public class UserDao extends AbstractDao<user>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public user login(user User) {
		return jdbcTemplate.queryForObject(UserSQL.LOGIN, new BeanPropertyRowMapper<>(user.class), new Object[] {User.getUsername(), User.getPassword()});
	}
	
	public user ExistedItem(user user) {
		return jdbcTemplate.queryForObject(UserSQL.EXISTED_USER, new BeanPropertyRowMapper<>(user.class), new Object[] {user.getUsername()});
	}

	@Override
	public List<user> selectAllItems() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(UserSQL.LIST_USER, new BeanPropertyRowMapper<>(user.class));
	}

	@Override
	public user selectItemById(user User) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(UserSQL.SELECT_CAT_BY_ID, new BeanPropertyRowMapper<>(user.class), new Object[] {User.getId()});
	}

	@Override
	public int addItem(user user) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.ADD_USER, new Object[] {user.getUsername(), user.getPassword(), user.getFullname()});
	}

	@Override
	public int editItem(user User) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.EDIT_USER, new Object[] {User.getUsername(), User.getPassword(), User.getFullname(), User.getId()});
	}

	@Override
	public int dellItem(user user) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.DEL_USER, new Object[] {user.getId()});
	}

}
