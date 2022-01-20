package cland.constant.sql;


public class CatSQL {

	public static final String ALL_CAT = "select * FROM categores";
	
	public static final String DEL_CAT = "DELETE FROM categores WHERE cid = ?";
	
	public static final String ADD_CAT = "INSERT INTO categores(cname) VALUES(?)";
	
	public static final String SELECT_CAT_BY_ID = "select * FROM categores WHERE cid = ?";
	
	public static final String EDIT_CAT = "UPDATE categores SET cname = ? WHERE cid = ?";
	
	public static final String EXISTED_CAT = "select * FROM categores WHERE cname = ?";
	
}
