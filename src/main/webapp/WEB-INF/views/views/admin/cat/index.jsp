<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý danh mục</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath}/admin/cat/add" class="btn btn-success"><span
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
							<th class="center text-center">ID</th>
							<th class="center text-center">Tên danh mục</th>
							<th class="center text-center">chức năng</th>
						</tr>
					</thead>
					<tbody>
					<c:choose>
						<c:when test="${ListCat != null}">
							<c:forEach items="${ListCat}" var="ListCat" >
								<tr class="odd gradeX">
									<td class="center text-center">${ListCat.cid}</td>
									<td class="center text-center">${ListCat.cname}</td>
									<td class="center text-center">
									<a href="${pageContext.request.contextPath}/admin/cat/edit/${ListCat.cid}" title=""class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a> 
									<a href="${pageContext.request.contextPath}/admin/cat/del/${ListCat.cid}" title="" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa')"><span class="glyphicon glyphicon-trash"></span> Xóa</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h1>Data Empty</h1>
						</c:otherwise>
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
	document.getElementById("cat").classList.add('current');
</script>