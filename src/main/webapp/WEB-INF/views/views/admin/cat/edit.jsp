<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa danh mục</div>
			</div>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>
					<h3>${msg}</h3>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
							<form action="${pageContext.request.contextPath}/admin/cat/edit/${cat.cid}" method="post">
								<form:errors cssStyle="color:red" path="error.cname"></form:errors>
								<br>
								<label for="name">Tên danh mục</label>
								<input type="text" class="form-control" placeholder="Nhập danh mục" name="cname" value="${cat.cname}">
								<br>
								<input class="btn btn-success" type="submit" value="Sửa">
							</form>
								
							</div>
						</div>
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
	document.getElementById("cat").classList.add('current');
</script>	