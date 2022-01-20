package cland.constant.sql;

public class UserSQL {
	
	public static final String LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
	
	public static final String LIST_USER = "SELECT * FROM users";
	
	public static final String ADD_USER = "INSERT INTO users(username, password, fullname) VALUES (?,?,?)";
	
	public static final String DEL_USER = "DELETE FROM users WHERE id = ?";
	
	public static final String EXISTED_USER = "SELECT * FROM users WHERE username = ?"; 
	
	public static final String SELECT_CAT_BY_ID = "SELECT * FROM users WHERE id = ?";
	
	public static final String EDIT_USER = "UPDATE users SET username = ?, password = ?, fullname = ? WHERE id = ?";

}
