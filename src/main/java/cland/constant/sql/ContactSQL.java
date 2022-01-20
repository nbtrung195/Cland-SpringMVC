package cland.constant.sql;

public class ContactSQL {
	
	public static final String ALL_CONTACT = "SELECT * FROM vnecontact";
	
	public static final String DEL_CONTACT = "DELETE FROM vnecontact WHERE cid = ?";
	
	public static final String SELECT_CONTACT_BY_ID = "SELECT * FROM vnecontact WHERE cid = ?";
	
	public static final String ADD_CONTACT = "INSERT INTO vnecontact(fullname, email, content) VALUES(?,?,?)";

}
