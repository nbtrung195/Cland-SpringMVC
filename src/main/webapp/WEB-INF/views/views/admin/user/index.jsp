<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý người dùng</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-success"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>
			</div>
			<div class="col-md-4">
				<h3>${msg}</h3>
			</div>
		</div>

		<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0"
					class="table table-striped table-bordered" id="myTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên đăng nhập</th>
							<th>Tên người dùng</th>
							<th>Chức năng</th>
						</tr>
					</thead>
					<tbody>
					<c:choose>
						<c:when test="${ListUser != null}">
						<c:forEach items="${ListUser}" var="ListUser">
						<tr class="odd gradeX">
							<td>${ListUser.id}</td>
							<td>${ListUser.username}</td>
							<td>${ListUser.fullname}</td>
							<td class="center text-center"><a href="${pageContext.request.contextPath}/admin/user/edit/${ListUser.id}" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href="${pageContext.request.contextPath}/admin/user/del/${ListUser.id}"
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
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
<script type="text/javascript">
	document.getElementById("user").classList.add('current');
</script>