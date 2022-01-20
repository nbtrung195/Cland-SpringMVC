package cland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cland.dao.CatDao;
import cland.model.cat;

@Service
public class CatService {

	@Autowired
	private CatDao catDao;
	
	public List<cat> ListCat(){
		try {
			catDao.selectAllItems();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return catDao.selectAllItems();
	}
	
	public int delCat(cat Cat) {
		return catDao.dellItem(Cat);
	}
	
	public int addCat(cat Cat) {
		return catDao.addItem(Cat);
	}
	
	public int editCat(cat Cat) {
		return catDao.editItem(Cat);
	}
	
	public cat getCatById(cat cat) {
		try {
			catDao.selectItemById(cat);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return catDao.selectItemById(cat);
	}
	
	public cat ExistedCat(cat cat) {
		try {
			catDao.ExistedItem(cat);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return catDao.ExistedItem(cat);
	}
	
}
