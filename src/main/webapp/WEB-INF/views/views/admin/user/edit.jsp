<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm người dùng</div>
		</div>
		<div class="content-box-large box-with-header">
			<div>
				<div class="row mb-10"></div>
				<h3>${msg}</h3>
				<div class="row">
					<form action="${pageContext.request.contextPath}/admin/user/edit/${user.id}" method="post">
						<div class="col-sm-6">
							<div class="form-group">
								<form:errors path="error.username" cssStyle="color:red"></form:errors>
								<br> <label for="name">Tên đăng nhập</label> <input
									type="text" name="username" class="form-control"
									value="${user.username}" placeholder="Nhập tên đăng nhập">
							</div>
							<div class="form-group">
								<form:errors path="error.password" cssStyle="color:red"></form:errors>
								<br> <label for="name">Tên mật khẩu</label> <input
									type="password" name="password" class="form-control"
									value="${user.password}" placeholder="Nhập mật khẩu">
							</div>
							<div class="form-group">
								<form:errors path="error.fullname" cssStyle="color:red"></form:errors>
								<br> <label for="name">Tên người dùng</label> <input
									type="text" name="fullname" class="form-control"
									value="${user.fullname}" placeholder="Nhập tên người dùng">
							</div>
							<div class="row">
								<div class="col-sm-12">
									<input type="submit" value="Thêm" class="btn btn-success" />
								</div>
							</div>
						</div>
					</form>
				</div>
				<hr>
			</div>
		</div>
	</div>
</div>
<!-- /.row col-size -->
</div>
<!-- /.col-md-10 -->
<script type="text/javascript">
	document.getElementById("user").classList.add('current');
</script>