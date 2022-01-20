package cland.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cland.constant.sql.CatSQL;
import cland.model.cat;

@Repository
public class CatDao extends AbstractDao<cat>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public cat ExistedItem(cat cat) {
		return jdbcTemplate.queryForObject(CatSQL.EXISTED_CAT, new BeanPropertyRowMapper<>(cat.class), new Object[] {cat.getCname()});
	}
	
	@Override
	public List<cat> selectAllItems() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(CatSQL.ALL_CAT, new BeanPropertyRowMapper<>(cat.class));
	}

	@Override
	public cat selectItemById(cat cat) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(CatSQL.SELECT_CAT_BY_ID, new BeanPropertyRowMapper<>(cat.class), new Object[] {cat.getCid()});
	}

	@Override
	public int addItem(cat cat) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(CatSQL.ADD_CAT, new Object[] {cat.getCname()});
	}

	@Override
	public int editItem(cat cat) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(CatSQL.EDIT_CAT, new Object[] {cat.getCname(),cat.getCid()});
	}

	@Override
	public int dellItem(cat Cat) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(CatSQL.DEL_CAT, new Object[] {Cat.getCid()});
	}

	
	
}
