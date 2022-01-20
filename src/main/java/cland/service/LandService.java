package cland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cland.dao.LandDao;
import cland.model.land;

@Service
public class LandService {

	@Autowired
	private LandDao landDao;
	
	public int IncreaseView(land land) {
		return landDao.IncreaseView(land);
	}
	
	public List<land> ListLand(){
		try {
			landDao.selectAllItems();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return landDao.selectAllItems();
	}
	
	public int addLand(land land) {
		return landDao.addItem(land);
	}
	
	public land selectLandById(land land) {
		try {
			landDao.selectItemById(land);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return landDao.selectItemById(land);
	}
	
	public int editLand(land land) {
		return landDao.editItem(land);
	}
	
	public int delLand(land land) {
		return landDao.dellItem(land);
	}
	
	public List<land> TopLand(){
		try {
			landDao.TopItems();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return landDao.TopItems();
	}
	
	public List<land> LandPerPage(int offset){
		try {
			landDao.ItemsPerPage(offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return landDao.ItemsPerPage(offset);
	}
	
	public List<land> selectLandByIdCat(int cid) {
		try {
			landDao.selectItemByIdCat(cid);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return landDao.selectItemByIdCat(cid);
	}
	
	public List<land> selectLandByIdCatLimit(int cid, int offset){
		try {
			landDao.selectItemByIdCatLimit(cid, offset);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return landDao.selectItemByIdCatLimit(cid, offset);
	}
	
	public List<land> selectRelativeLand(land land){
		return landDao.selectRelativeItems(land);
	}
	
	public List<land> searchLand(land search){
		return landDao.searchItems(search);
	}
	
}
