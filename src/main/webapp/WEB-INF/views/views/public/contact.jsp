<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>		
				<div class="clearfix main_content floatleft">
					<div class="clearfix content">
						<div class="contact_us">
							<h1>Liên hệ với chúng tôi</h1>
							
							<p>
							TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br />
							Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br />
							Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
							</p><br>
							<div>${msg}</div>
							<form action="${pageContext.request.contextPath}/public/contact" method="post">
								<form:errors path="error.fullname" cssStyle="color:red"></form:errors><br>
								<p><input type="text" class="wpcf7-text" placeholder="Họ tên *" name="fullname"/></p>
								<form:errors path="error.email" cssStyle="color:red"></form:errors><br>
								<p><input type="text" class="wpcf7-email" placeholder="Email *" name="email"/></p>
								<form:errors path="error.content" cssStyle="color:red"></form:errors><br>
								<p><textarea class="wpcf7-textarea" placeholder="Nội dung *" name="content"></textarea></p>
								<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
							</form>
							
						</div>
						
					</div>
					
					
				</div>
				