package cland.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {

	private int id;
	
	@Size(min = 5, max = 14, message = "Tên đăng nhập phải từ 5-14 kí tự")
	private String username;
	
	@Size(min = 6, max = 14, message = "Mật khẩu phải từ 6-14 kí tự")
	private String password;
	
	@NotEmpty(message = "Tên người dùng không được để trống")
	private String fullname;
	
}
