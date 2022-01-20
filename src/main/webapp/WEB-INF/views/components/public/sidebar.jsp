<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix sidebar_container floatright">
	<div class="clearfix sidebar">
		<div class="clearfix single_sidebar category_items">
			<h2>Danh mục bất động sản</h2>
			<ul>
				<c:choose>
					<c:when test="${listCat != null}">
						<c:forEach items="${listCat}" var="listCat">
							<li class="cat-item"><a
								href="${pageContext.request.contextPath}/public/cat/${listCat.cid}/1">${listCat.cname}</a>(12)</li>
						</c:forEach>
					</c:when>
					<c:otherwise>Data Empty</c:otherwise>
				</c:choose>
			</ul>
		</div>

		<div class="clearfix single_sidebar">
			<div class="popular_post">
				<div class="sidebar_title">
					<h2>Xem nhiều</h2>
				</div>
				<ul>
					<c:choose>
						<c:when test="${TopLand != null}">
							<c:forEach items="${TopLand}" var="TopLand">
								<li><a
									href="${pageContext.request.contextPath}/public/detail/${TopLand.lid}">${TopLand.lname}</a></li>
							</c:forEach>
						</c:when>
						<c:otherwise>Data Empty</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
</div>