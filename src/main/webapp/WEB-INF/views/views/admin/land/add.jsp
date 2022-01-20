<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		  <div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm bài viết</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								<form action="${pageContext.request.contextPath}/admin/land/add" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<form:errors cssStyle="color:red" path="error.lname"></form:errors><br>
											<label for="name">Tên bài viết</label>
											<input type="text" class="form-control" placeholder="Nhập tên bài viết" name="lname">
										</div>
										
										<div class="form-group">
											<label>Danh mục</label>
											<select class="form-control" name="cid">
											<c:forEach items="${listcat}" var="listcat">
												<option value="${listcat.cid}">${listcat.cname}</option>
											</c:forEach>
											</select>
										</div>
										
										<div class="form-group">
											<form:errors cssStyle="color:red" path="error.address"></form:errors><br>
											<label for="name">Địa chỉ</label>
											<input type="text" class="form-control" placeholder="Nhập địa chỉ" name="address">
										</div>
										
										<div class="form-group">
											<form:errors cssStyle="color:red" path="error.area"></form:errors><br>
											<label for="name">Diên tích</label>
											<input type="text" class="form-control" placeholder="Nhập diện tích" name="area">
										</div>

										<div class="form-group">
										    <form:errors cssStyle="color:red" path="error.picture"></form:errors><br>
											<label>Thêm hình ảnh</label>
											<input type="file" class="btn btn-default" id="exampleInputFile1" name="hinhanh">
											<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
										</div>
										
										<div class="form-group">
										   <form:errors cssStyle="color:red" path="error.description"></form:errors><br>
										   <label>Mô tả</label>
										   <textarea class="form-control" rows="3" name="description" ></textarea>
										</div>
										
									</div>

									<div class="col-sm-6"></div>

									<div class="col-sm-12">
										<div class="form-group">
										   <form:errors cssStyle="color:red" path="error.detail"></form:errors><br>
										   <label>Chi tiết</label>
										   <textarea class="form-control" rows="7" name="detail"></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Thêm" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>
								</form>
								<hr>

						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->
	</div>
<script type="text/javascript">
	document.getElementById("land").classList.add('current');
</script>