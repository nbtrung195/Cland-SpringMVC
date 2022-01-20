<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar content-box" style="display: block;">
	<!-- Nav-bar -->
	<ul class="nav">
		<!-- Main menu -->
		<li id="home"><a href="${pageContext.request.contextPath}/admin/home"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
		<li id="cat"><a href="${pageContext.request.contextPath}/admin/cat/index"><i class="glyphicon glyphicon-list"></i>Danh mục</a></li>
		<li id="land"><a href="${pageContext.request.contextPath}/admin/land/index"><i class="glyphicon glyphicon-book"></i>Nhà đất</a></li>
		<li id="user"><a href="${pageContext.request.contextPath}/admin/user/index"><i class="glyphicon glyphicon-plus"></i>Người dùng</a></li>
		<li class="submenu"><a href="#"> <i class="glyphicon glyphicon-list"></i> Khác <span class="caret pull-right"></span>
		</a> <!-- Sub menu -->
			<ul>
				<li id="contact"><a href="${pageContext.request.contextPath}/admin/contact/index">Liên hệ</a></li>
				<li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
			</ul></li>
	</ul>
	<!-- /.nav-bar -->
</div>