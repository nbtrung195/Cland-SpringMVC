package cland.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class land {
	
	private int lid;
	
	@NotEmpty(message = "Tên bài viết không được để trống")
	private String lname;
	
	@NotEmpty(message = "Mô tả không được để trống")
	private String description;
	
	private String date_create;
	
	private int cid;
	
	private String cname;
	
	private String picture;
	
	@NotEmpty(message = "Chi tiết bài viết không được để trống")
	private String detail;
	
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String address;
	
	private int views;
	
	@NotNull(message = "Diện tích không được để trống")
	private Integer area;

}
