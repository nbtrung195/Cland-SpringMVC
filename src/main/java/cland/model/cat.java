package cland.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class cat {
	
	private int cid;
	
	@NotEmpty(message = "Tên danh mục không được để trống")
	private String cname;

}
