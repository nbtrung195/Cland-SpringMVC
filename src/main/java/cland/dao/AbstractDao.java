package cland.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDao<T> {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public abstract List<T> selectAllItems();
	
	public abstract T selectItemById(T t);
	
	public abstract int addItem(T t);
	
	public abstract int editItem(T t);
	
	public abstract int dellItem(T t);
	
	

}
