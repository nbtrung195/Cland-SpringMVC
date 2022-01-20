<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">
	<c:url value="/resources" var="contextPath" scope="application"></c:url>
	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý truyện</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath}/admin/land/add" class="btn btn-success"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

			</div>
			<h3>${msg}</h3>
		</div>
		
		<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0"
					class="table table-striped table-bordered" id="myTable">
					<thead>
						<tr>
							<th class="center text-center">ID</th>
							<th class="center text-center">Tên bài viết</th>
							<th class="center text-center">Địa chỉ</th>
							<th class="center text-center">Diện tích</th>
							<th class="center text-center">Hình ảnh</th>
							<th class="center text-center">Ngày đăng</th>
							<th class="center text-center">Danh mục</th>
							<th class="center text-center">Mô tả</th>
							<th class="center text-center">Lượt đọc</th>
							<th class="center text-center">Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${ListLand != null}">
								<c:forEach items="${ListLand}" var="ListLand">
									<tr class="odd gradeX">
										<td class="center text-center">${ListLand.lid}</td>
										<td class="center text-center">${ListLand.lname}</td>
										<td class="center text-center">${ListLand.address}</td>
										<td class="center text-center">${ListLand.area}</td>
										<td class="center text-center"><img width="100px" src="${contextPath}/upload/${ListLand.picture}" alt=""/>
										<td class="center text-center">${ListLand.date_create}</td>
										<td class="center text-center"">${ListLand.cname}</td>
										<td class="center text-center"">${ListLand.description}</td>
										<td class="center text-center"">${ListLand.views}</td>
										<td class="center text-center"><a href="${pageContext.request.contextPath}/admin/land/edit/${ListLand.lid}" title=""
											class="btn btn-primary"><span
												class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href="${pageContext.request.contextPath}/admin/land/del/${ListLand.lid}"
											title="" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa')"><span
												class="glyphicon glyphicon-trash"></span> Xóa</a></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>Data Empty</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.content-box-large -->
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable();
	});
</script>
<script type="text/javascript">
	document.getElementById("land").classList.add('current');
</script>