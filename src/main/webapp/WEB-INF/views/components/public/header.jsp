<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="header_area">
	<div class="wrapper header">
		<div class="clearfix header_top">
			<div class="clearfix logo floatleft">
				<a href="${pageContext.request.contextPath}/public/index/1"><h1>
						<span>C</span>Land
					</h1></a>
			</div>
			<div class="clearfix search floatright">
				<form action="${pageContext.request.contextPath}/public/search" method="get">
					<input type="text" placeholder="Search" name="lname"/> <input type="submit" />
				</form>
			</div>
		</div>
		<div class="header_bottom">
			<nav>
				<ul id="nav">
					<li><a
						href="${pageContext.request.contextPath}/public/index/1">Trang
							chủ</a></li>
					<li id="dropdown"><a href="javascript:void(0)">Bất động
							sản</a>
						<ul>
							<c:choose>
								<c:when test="${listCat != null}">
									<c:forEach items="${listCat}" var="listCat">
										<li><a
											href="${pageContext.request.contextPath}/public/cat/${listCat.cid}/1">${listCat.cname}</a></li>
									</c:forEach>
								</c:when>
								<c:otherwise>Data empty</c:otherwise>
							</c:choose>
						</ul></li>
					<li><a href="${pageContext.request.contextPath}/public/contact">Liên hệ</a></li>
				</ul>
			</nav>
		</div>
	</div>
</section>