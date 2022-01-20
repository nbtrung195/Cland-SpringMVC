package cland.constant.sql;

public class LandSQL {
	
	public static final String ALL_LAND = "SELECT lands.lid, lands.lname, lands.description, lands.date_create, lands.picture, categores.cname, lands.views, "
                                        + "lands.address, lands.area FROM lands INNER JOIN categores ON lands.cid = categores.cid"; 
	
	public static final String ADD_LANDS = "INSERT INTO lands(lname,description,cid,picture,detail,address,area) VALUES(?,?,?,?,?,?,?)";
	
	public static final String SELECT_LAND_BY_ID = "SELECT lands.lid, lands.lname, lands.description, lands.date_create, lands.picture, categores.cname, lands.views, lands.cid,"
            									 + "lands.address, lands.area, lands.detail FROM lands INNER JOIN categores ON lands.cid = categores.cid WHERE lands.lid = ?"; 
	
	public static final String EDIT_LAND = "UPDATE lands SET lname = ?, description = ?, cid = ?, picture = ?, detail = ?, address = ?, area = ? WHERE lid = ?";
	
	public static final String DEL_LAND = "DELETE FROM lands WHERE lid = ?";
	
	public static final String TOP_LAND = "SELECT * FROM lands ORDER BY views DESC LIMIT 5";
	
	public static final String LAND_PER_PAGE = "SELECT * FROM lands ORDER BY lid DESC LIMIT ?,3";
	
	public static final String SELECT_LAND_BY_ID_CAT = "SELECT * FROM lands WHERE cid = ?";
	
	public static final String LAND_PER_CAT = "SELECT * FROM lands WHERE cid = ? ORDER BY lid DESC LIMIT ?,4";
	
	public static final String RELATIVE_LAND = "SELECT * FROM lands WHERE cid = ? AND lid != ? ORDER BY lid DESC LIMIT 3";
	
	public static final String SEARCH_LAND = "SELECT * FROM lands WHERE lname LIKE ? ORDER BY lid DESC";
	
	public static final String 	INCREASE_VIEW = "UPDATE lands SET views = views + 1 WHERE lid = ?";
	
}
