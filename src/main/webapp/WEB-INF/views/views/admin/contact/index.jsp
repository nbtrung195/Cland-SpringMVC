<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading col-md-8">
				<div class="panel-title ">Quản lý liên hệ</div>
			</div>
			<div class="panel-heading col-md-4">
				<div class="panel-title ">${msg}</div>
			</div>
		</div>
	
		<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0"
					class="table table-striped table-bordered" id="myTable">
					<thead>
						<tr>
							<th class="center text-center">ID</th>
							<th class="center text-center">Họ tên</th>
							<th class="center text-center">Email</th>
							<th class="center text-center">Nội dung</th>
							<th class="center text-center">Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${contact != null}">
								<c:forEach items="${contact}" var="contact">
									<tr class="odd gradeX">
										<td class="center text-center">${contact.cid}</td>
										<td class="center text-center">${contact.fullname}</td>
										<td class="center text-center">${contact.email}</td>
										<td class="center text-center">${contact.content}</td>
										<td class="center text-center"><a
											href="${pageContext.request.contextPath}/admin/contact/del/${contact.cid}"
											title="" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa')"><span
												class="glyphicon glyphicon-trash" ></span> Xóa</a></td>
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
	document.getElementById("contact").classList.add('current');
</script>