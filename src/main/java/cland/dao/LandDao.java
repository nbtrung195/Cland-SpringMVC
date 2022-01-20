package cland.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cland.constant.sql.LandSQL;
import cland.model.land;


@Repository
public class LandDao extends AbstractDao<land>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<land> TopItems(){
		return jdbcTemplate.query(LandSQL.TOP_LAND, new BeanPropertyRowMapper<>(land.class));
	}
	
	public List<land> ItemsPerPage(int offset){
		return jdbcTemplate.query(LandSQL.LAND_PER_PAGE, new BeanPropertyRowMapper<>(land.class), new Object[] {offset});
	}
	
	public List<land> selectItemByIdCat(int cid) {
		return jdbcTemplate.query(LandSQL.SELECT_LAND_BY_ID_CAT, new BeanPropertyRowMapper<>(land.class), new Object[] {cid});
	}
	
	public List<land> selectItemByIdCatLimit(int cid,int offset){
		return jdbcTemplate.query(LandSQL.LAND_PER_CAT, new BeanPropertyRowMapper<>(land.class), new Object[] {cid,offset});
	}
	
	public List<land> selectRelativeItems(land land){
		return jdbcTemplate.query(LandSQL.RELATIVE_LAND, new BeanPropertyRowMapper<>(land.class), new Object[] {land.getCid(), land.getLid()});
	}
	
	public List<land> searchItems(land search){
		return jdbcTemplate.query(LandSQL.SEARCH_LAND, new BeanPropertyRowMapper<>(land.class), new Object[] {"%" + search.getLname() + "%"});
	}
	
	public int IncreaseView(land land) {
		return jdbcTemplate.update(LandSQL.INCREASE_VIEW, new Object[] {land.getLid()});
	}

	@Override
	public List<land> selectAllItems() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(LandSQL.ALL_LAND, new BeanPropertyRowMapper<>(land.class));
	}

	@Override
	public land selectItemById(land land) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(LandSQL.SELECT_LAND_BY_ID, new BeanPropertyRowMapper<>(land.class), new Object[] {land.getLid()});
	}

	@Override
	public int addItem(land land) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(LandSQL.ADD_LANDS, new Object[] {land.getLname(),land.getDescription(),land.getCid(),land.getPicture(),land.getDetail(),land.getAddress(),land.getArea()});
	}

	@Override
	public int editItem(land land) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(LandSQL.EDIT_LAND, new Object[] {land.getLname(), land.getDescription(),land.getCid(),land.getPicture(),land.getDetail(),land.getAddress(),land.getArea(),land.getLid()});
	}

	@Override
	public int dellItem(land land) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(LandSQL.DEL_LAND, new Object [] {land.getLid()});
	}

	
	
}
