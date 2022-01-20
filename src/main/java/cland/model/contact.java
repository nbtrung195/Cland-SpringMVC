package cland.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class contact {
	
	private int cid;
	
	@NotEmpty(message = "Tên không được để trống")
	private String fullname;
	
	@Email(message = "Email không hợp lệ")
	@NotBlank(message = "Email không hợp lệ")
	private String email;
	
	@NotEmpty(message = "Nội dung không được để trống")
	private String content;

}
